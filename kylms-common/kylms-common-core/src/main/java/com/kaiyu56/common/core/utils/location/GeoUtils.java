package com.kaiyu56.common.core.utils.location;

import com.kaiyu56.common.core.domain.Geo;
import com.kaiyu56.common.core.utils.math.XMathUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static com.kaiyu56.common.core.utils.math.XMathUtil.multiply;

/**
 * @author: cssly
 * @date: 2021/4/21 1:11
 * @description:
 * @url:
 */
public class GeoUtils {


    private static BigDecimal π = new BigDecimal(Math.PI);
    private static BigDecimal TWO = new BigDecimal(BigInteger.TWO, 0);
    /**
     * 地球半径：6371000M
     */
    private static BigDecimal EARTH_RADIUS = new BigDecimal("6371000");

    /**
     * 任意地球经度周长
     * 地球周长：2 * 6371000M * π = 40030173
     */
    private static BigDecimal EARTH_GIRTH_LAT = multiply(multiply(EARTH_RADIUS, new BigDecimal("2.000000")), π).setScale(2, RoundingMode.CEILING);
    /**
     * 纬度38地球周长：40030173 * cos38 = 31544206M
     */
    private static BigDecimal EARTH_GIRTH_LNG = EARTH_GIRTH_LAT.multiply(new BigDecimal(Math.cos(Math.toRadians(38)))).setScale(2, RoundingMode.CEILING);
    /**
     * 经度（东西方向）1M实际度：360°/31544206M=1.141255544679108e-5=0.00001141
     */
    private static BigDecimal METER_LNG = XMathUtil.divide(new BigDecimal("360"), EARTH_GIRTH_LNG, 8);
    /**
     * 纬度（南北方向）1M实际度：360°/40030173M=8.993216192195822e-6=0.00000899
     */
    private static BigDecimal METER_LAT = XMathUtil.divide(new BigDecimal("360"), EARTH_GIRTH_LAT, 8);

    private static BigDecimal SIN_90 = new BigDecimal(Math.sin(Math.toRadians(90)));
    private static BigDecimal COS_90 = new BigDecimal(Math.cos(Math.toRadians(90)));

    /*
     * 已知三角形两边a,b,这两边夹角C，则S＝absinC/2
     * 经度（东西方向）100M实际度：0.00001141°* 100=0.001141°
     *
     * 纬度（南北方向）100M实际度：0.00000899°* 100=0.000899°
     *
     */


    /**
     * 根据经纬度和距离返回一个矩形范围
     *
     * @param lng      经度
     * @param lat      纬度
     * @param distance 距离(单位为米)
     * @return [lng1, lat1, lng2,lat2] 矩形的左下角(lng1,lat1)和右上角(lng2,lat2)
     */
    public static double[] getRectangle(double lng, double lat, long distance) {
        float delta = 111000;
        if (lng != 0 && lat != 0) {
            double abs = Math.abs(Math.cos(Math.toRadians(lat)) * delta);
            double lng1 = lng - distance / abs;
            double lng2 = lng + distance / abs;
            double lat1 = lat - (distance / delta);
            double lat2 = lat + (distance / delta);
            return new double[]{lng1, lat1, lng2, lat2};
        } else {
            // TODO ZHCH 等于0时的计算公式
            double lng1 = lng - distance / delta;
            double lng2 = lng + distance / delta;
            double lat1 = lat - (distance / delta);
            double lat2 = lat + (distance / delta);
            return new double[]{lng1, lat1, lng2, lat2};
        }
    }


    /**
     * 地球半径：6378.137KM
     */
    /**
     * 计算两经纬度点之间的距离（单位：米）
     *
     * @param start
     * @param end
     * @return
     */
    public static BigDecimal getDistance(Geo start, Geo end) {
        BigDecimal startLng = start.getLng();
        BigDecimal startLat = start.getLat();
        BigDecimal endLng = end.getLng();
        BigDecimal endLat = end.getLat();

        BigDecimal radLat1 = rad(startLat);
        BigDecimal radLat2 = rad(endLat);

        BigDecimal a = radLat1.subtract(radLat2);
        BigDecimal b = rad(startLng).subtract(rad(endLng));
        BigDecimal s = new BigDecimal(
                Math.asin(Math.sqrt(Math.pow(Math.sin(a.divide(TWO).doubleValue()), 2) +
                        Math.cos(radLat1.doubleValue()) * Math.cos(radLat2.doubleValue()) *
                                Math.pow(Math.sin(b.divide(TWO).doubleValue()), 2)))
        ).multiply(TWO);
        s = s.multiply(EARTH_RADIUS);
        BigDecimal tenThousand = new BigDecimal("10000");
        s = XMathUtil.divide(new BigDecimal(Math.round(s.multiply(tenThousand).doubleValue())), tenThousand);
        return s;
    }

    public static BigDecimal getDistanceX(Geo start, Geo end) {
        BigDecimal a = XMathUtil.subtract(start.getLng(), end.getLng()).abs();
        BigDecimal b = XMathUtil.subtract(start.getLat(), end.getLat()).abs();
        BigDecimal tenThousand = new BigDecimal("100000");
        return multiply(new BigDecimal(Math.sqrt(a.multiply(a).add(b.multiply(b)).doubleValue())),tenThousand).setScale(2,RoundingMode.CEILING);
    }

    private static BigDecimal rad(BigDecimal d) {
        return d.multiply(π).divide(new BigDecimal("180"), 10, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
//        Geo start = new Geo(113.361099, 23.292762);
//        Geo end = new Geo(113.36007, 23.289596);
//        Geo start = new Geo(113.34059,23.294179);
//        Geo end = new Geo(113.360668,23.294179);
        Geo start = new Geo(118.105896,24.540000);
        Geo end = new Geo(118.105896,24.538735);
        System.out.println("距离" + getDistance(start, end) + "米");
        System.out.println("距离" + getDistanceX(start, end) + "米");
    }
}
