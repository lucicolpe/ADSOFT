/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import converter.SiLength2ImperialConverter;
import exceptions.*;
import magnitude.Magnitude;
import metricsystem.*;
import units.composite.CompositeUnit;
import units.composite.Operator;

/**
 *
 * @author Mighark
 */
public class CompositeTest {

    public static void main(String[] args) throws QuantityException,UnknownUnitException {
        SiLengthMetricSystem.registerConverter(new SiLength2ImperialConverter());
        Magnitude velocSI = new Magnitude(10, new CompositeUnit(SiLengthMetricSystem.METER, Operator.DIV, SiTimeMetricSystem.SECOND));
        Magnitude velocImp = new Magnitude(0, new CompositeUnit(ImperialLengthMetricSystem.MILE, Operator.DIV, SiTimeMetricSystem.HOUR));
        Magnitude velocSI2 = new Magnitude(0, new CompositeUnit(SiLengthMetricSystem.KILOMETER, Operator.DIV, SiTimeMetricSystem.HOUR));
        System.out.println(velocSI);
        System.out.println(velocImp);
        System.out.println(velocImp.add(velocSI));
        // implica convertir m/s a millas/hora
        System.out.println(velocSI2.add(velocSI));
        // implica convertir m/s a km/hora
    }
}
