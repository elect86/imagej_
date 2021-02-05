/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2014 - 2016 Board of Regents of the University of
 * Wisconsin-Madison, University of Konstanz and Brian Northan.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package net.imagej.ops.math;

import net.imagej.ops.AbstractOp;
import net.imagej.ops.Ops;

import org.scijava.ItemIO;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

/**
 * Generated arithmetic ops with primitive types.
 *
 * @author Curtis Rueden
 */
public final class PrimitiveMath {

	private PrimitiveMath() {
		// NB: Prevent instantiation of utility class.
	}

	/** Op that adds ({@literal +}) two int values. */
	@Plugin(type = Ops.Math.Add.class, priority = 0.4)
	public static class IntegerAdd extends AbstractOp
		implements Ops.Math.Add
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = a + b;
		}
	}

	/** Op that subtracts ({@literal -}) two int values. */
	@Plugin(type = Ops.Math.Subtract.class, priority = 0.4)
	public static class IntegerSubtract extends AbstractOp
		implements Ops.Math.Subtract
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = a - b;
		}
	}

	/** Op that multiplies ({@literal *}) two int values. */
	@Plugin(type = Ops.Math.Multiply.class, priority = 0.4)
	public static class IntegerMultiply extends AbstractOp
		implements Ops.Math.Multiply
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = a * b;
		}
	}

	/** Op that divides ({@literal /}) two int values. */
	@Plugin(type = Ops.Math.Divide.class, priority = 0.4)
	public static class IntegerDivide extends AbstractOp
		implements Ops.Math.Divide
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = a / b;
		}
	}

	/** Op that computes the remainder ({@literal %}) of two int values. */
	@Plugin(type = Ops.Math.Remainder.class, priority = 0.4)
	public static class IntegerRemainder extends AbstractOp
		implements Ops.Math.Remainder
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = a % b;
		}
	}

	/** Op that computes the bitwise AND ({@literal &}) of two int values. */
	@Plugin(type = Ops.Math.And.class, priority = 0.4)
	public static class IntegerAnd extends AbstractOp
		implements Ops.Math.And
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = a & b;
		}
	}

	/** Op that computes the bitwise OR ({@literal |}) of two int values. */
	@Plugin(type = Ops.Math.Or.class, priority = 0.4)
	public static class IntegerOr extends AbstractOp
		implements Ops.Math.Or
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = a | b;
		}
	}

	/** Op that computes the bitwise XOR ({@literal ^}) of two int values. */
	@Plugin(type = Ops.Math.Xor.class, priority = 0.4)
	public static class IntegerXor extends AbstractOp
		implements Ops.Math.Xor
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = a ^ b;
		}
	}

	/** Op that computes the signed left shift ({@literal <<}) of two int values. */
	@Plugin(type = Ops.Math.LeftShift.class, priority = 0.4)
	public static class IntegerLeftShift extends AbstractOp
		implements Ops.Math.LeftShift
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = a << b;
		}
	}

	/** Op that computes the signed right shift ({@literal >>}) of two int values. */
	@Plugin(type = Ops.Math.RightShift.class, priority = 0.4)
	public static class IntegerRightShift extends AbstractOp
		implements Ops.Math.RightShift
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = a >> b;
		}
	}

	/** Op that computes the unsigned right shift ({@literal >>>}) of two int values. */
	@Plugin(type = Ops.Math.UnsignedRightShift.class, priority = 0.4)
	public static class IntegerUnsignedRightShift extends AbstractOp
		implements Ops.Math.UnsignedRightShift
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = a >>> b;
		}
	}

	/** Op that computes the maximum of two int values. */
	@Plugin(type = Ops.Math.Max.class, priority = 0.4)
	public static class IntegerMax extends AbstractOp
		implements Ops.Math.Max
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = Math.max(a, b);
		}
	}

	/** Op that computes the minimum of two int values. */
	@Plugin(type = Ops.Math.Min.class, priority = 0.4)
	public static class IntegerMin extends AbstractOp
		implements Ops.Math.Min
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Parameter
		private int b;

		@Override
		public void run() {
			result = Math.min(a, b);
		}
	}

	/** Op that computes the bitwise complement ({@literal ~}) of a int value. */
	@Plugin(type = Ops.Math.Complement.class, priority = 0.4)
	public static class IntegerComplement extends AbstractOp
		implements Ops.Math.Complement
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Override
		public void run() {
			result = ~a;
		}
	}

	/** Op that negates ({@literal -}) a int value. */
	@Plugin(type = Ops.Math.Negate.class, priority = 0.4)
	public static class IntegerNegate extends AbstractOp
		implements Ops.Math.Negate
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Override
		public void run() {
			result = -a;
		}
	}

	/** Op that computes the absolute value of a int value. */
	@Plugin(type = Ops.Math.Abs.class, priority = 0.4)
	public static class IntegerAbs extends AbstractOp
		implements Ops.Math.Abs
	{
		@Parameter(type = ItemIO.OUTPUT)
		private int result;

		@Parameter
		private int a;

		@Override
		public void run() {
			result = Math.abs(a);
		}
	}

	/** Op that adds ({@literal +}) two long values. */
	@Plugin(type = Ops.Math.Add.class, priority = 0.3)
	public static class LongAdd extends AbstractOp
		implements Ops.Math.Add
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = a + b;
		}
	}

	/** Op that subtracts ({@literal -}) two long values. */
	@Plugin(type = Ops.Math.Subtract.class, priority = 0.3)
	public static class LongSubtract extends AbstractOp
		implements Ops.Math.Subtract
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = a - b;
		}
	}

	/** Op that multiplies ({@literal *}) two long values. */
	@Plugin(type = Ops.Math.Multiply.class, priority = 0.3)
	public static class LongMultiply extends AbstractOp
		implements Ops.Math.Multiply
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = a * b;
		}
	}

	/** Op that divides ({@literal /}) two long values. */
	@Plugin(type = Ops.Math.Divide.class, priority = 0.3)
	public static class LongDivide extends AbstractOp
		implements Ops.Math.Divide
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = a / b;
		}
	}

	/** Op that computes the remainder ({@literal %}) of two long values. */
	@Plugin(type = Ops.Math.Remainder.class, priority = 0.3)
	public static class LongRemainder extends AbstractOp
		implements Ops.Math.Remainder
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = a % b;
		}
	}

	/** Op that computes the bitwise AND ({@literal &}) of two long values. */
	@Plugin(type = Ops.Math.And.class, priority = 0.3)
	public static class LongAnd extends AbstractOp
		implements Ops.Math.And
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = a & b;
		}
	}

	/** Op that computes the bitwise OR ({@literal |}) of two long values. */
	@Plugin(type = Ops.Math.Or.class, priority = 0.3)
	public static class LongOr extends AbstractOp
		implements Ops.Math.Or
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = a | b;
		}
	}

	/** Op that computes the bitwise XOR ({@literal ^}) of two long values. */
	@Plugin(type = Ops.Math.Xor.class, priority = 0.3)
	public static class LongXor extends AbstractOp
		implements Ops.Math.Xor
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = a ^ b;
		}
	}

	/** Op that computes the signed left shift ({@literal <<}) of two long values. */
	@Plugin(type = Ops.Math.LeftShift.class, priority = 0.3)
	public static class LongLeftShift extends AbstractOp
		implements Ops.Math.LeftShift
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = a << b;
		}
	}

	/** Op that computes the signed right shift ({@literal >>}) of two long values. */
	@Plugin(type = Ops.Math.RightShift.class, priority = 0.3)
	public static class LongRightShift extends AbstractOp
		implements Ops.Math.RightShift
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = a >> b;
		}
	}

	/** Op that computes the unsigned right shift ({@literal >>>}) of two long values. */
	@Plugin(type = Ops.Math.UnsignedRightShift.class, priority = 0.3)
	public static class LongUnsignedRightShift extends AbstractOp
		implements Ops.Math.UnsignedRightShift
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = a >>> b;
		}
	}

	/** Op that computes the maximum of two long values. */
	@Plugin(type = Ops.Math.Max.class, priority = 0.3)
	public static class LongMax extends AbstractOp
		implements Ops.Math.Max
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = Math.max(a, b);
		}
	}

	/** Op that computes the minimum of two long values. */
	@Plugin(type = Ops.Math.Min.class, priority = 0.3)
	public static class LongMin extends AbstractOp
		implements Ops.Math.Min
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Parameter
		private long b;

		@Override
		public void run() {
			result = Math.min(a, b);
		}
	}

	/** Op that computes the bitwise complement ({@literal ~}) of a long value. */
	@Plugin(type = Ops.Math.Complement.class, priority = 0.3)
	public static class LongComplement extends AbstractOp
		implements Ops.Math.Complement
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Override
		public void run() {
			result = ~a;
		}
	}

	/** Op that negates ({@literal -}) a long value. */
	@Plugin(type = Ops.Math.Negate.class, priority = 0.3)
	public static class LongNegate extends AbstractOp
		implements Ops.Math.Negate
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Override
		public void run() {
			result = -a;
		}
	}

	/** Op that computes the absolute value of a long value. */
	@Plugin(type = Ops.Math.Abs.class, priority = 0.3)
	public static class LongAbs extends AbstractOp
		implements Ops.Math.Abs
	{
		@Parameter(type = ItemIO.OUTPUT)
		private long result;

		@Parameter
		private long a;

		@Override
		public void run() {
			result = Math.abs(a);
		}
	}

	/** Op that adds ({@literal +}) two float values. */
	@Plugin(type = Ops.Math.Add.class, priority = 0.2)
	public static class FloatAdd extends AbstractOp
		implements Ops.Math.Add
	{
		@Parameter(type = ItemIO.OUTPUT)
		private float result;

		@Parameter
		private float a;

		@Parameter
		private float b;

		@Override
		public void run() {
			result = a + b;
		}
	}

	/** Op that subtracts ({@literal -}) two float values. */
	@Plugin(type = Ops.Math.Subtract.class, priority = 0.2)
	public static class FloatSubtract extends AbstractOp
		implements Ops.Math.Subtract
	{
		@Parameter(type = ItemIO.OUTPUT)
		private float result;

		@Parameter
		private float a;

		@Parameter
		private float b;

		@Override
		public void run() {
			result = a - b;
		}
	}

	/** Op that multiplies ({@literal *}) two float values. */
	@Plugin(type = Ops.Math.Multiply.class, priority = 0.2)
	public static class FloatMultiply extends AbstractOp
		implements Ops.Math.Multiply
	{
		@Parameter(type = ItemIO.OUTPUT)
		private float result;

		@Parameter
		private float a;

		@Parameter
		private float b;

		@Override
		public void run() {
			result = a * b;
		}
	}

	/** Op that divides ({@literal /}) two float values. */
	@Plugin(type = Ops.Math.Divide.class, priority = 0.2)
	public static class FloatDivide extends AbstractOp
		implements Ops.Math.Divide
	{
		@Parameter(type = ItemIO.OUTPUT)
		private float result;

		@Parameter
		private float a;

		@Parameter
		private float b;

		@Override
		public void run() {
			result = a / b;
		}
	}

	/** Op that computes the remainder ({@literal %}) of two float values. */
	@Plugin(type = Ops.Math.Remainder.class, priority = 0.2)
	public static class FloatRemainder extends AbstractOp
		implements Ops.Math.Remainder
	{
		@Parameter(type = ItemIO.OUTPUT)
		private float result;

		@Parameter
		private float a;

		@Parameter
		private float b;

		@Override
		public void run() {
			result = a % b;
		}
	}

	/** Op that computes the maximum of two float values. */
	@Plugin(type = Ops.Math.Max.class, priority = 0.2)
	public static class FloatMax extends AbstractOp
		implements Ops.Math.Max
	{
		@Parameter(type = ItemIO.OUTPUT)
		private float result;

		@Parameter
		private float a;

		@Parameter
		private float b;

		@Override
		public void run() {
			result = Math.max(a, b);
		}
	}

	/** Op that computes the minimum of two float values. */
	@Plugin(type = Ops.Math.Min.class, priority = 0.2)
	public static class FloatMin extends AbstractOp
		implements Ops.Math.Min
	{
		@Parameter(type = ItemIO.OUTPUT)
		private float result;

		@Parameter
		private float a;

		@Parameter
		private float b;

		@Override
		public void run() {
			result = Math.min(a, b);
		}
	}

	/** Op that negates ({@literal -}) a float value. */
	@Plugin(type = Ops.Math.Negate.class, priority = 0.2)
	public static class FloatNegate extends AbstractOp
		implements Ops.Math.Negate
	{
		@Parameter(type = ItemIO.OUTPUT)
		private float result;

		@Parameter
		private float a;

		@Override
		public void run() {
			result = -a;
		}
	}

	/** Op that computes the absolute value of a float value. */
	@Plugin(type = Ops.Math.Abs.class, priority = 0.2)
	public static class FloatAbs extends AbstractOp
		implements Ops.Math.Abs
	{
		@Parameter(type = ItemIO.OUTPUT)
		private float result;

		@Parameter
		private float a;

		@Override
		public void run() {
			result = Math.abs(a);
		}
	}

	/** Op that rounds a float value. */
	@Plugin(type = Ops.Math.Round.class, priority = 0.2)
	public static class FloatRound extends AbstractOp
		implements Ops.Math.Round
	{
		@Parameter(type = ItemIO.OUTPUT)
		private float result;

		@Parameter
		private float a;

		@Override
		public void run() {
			result = Math.round(a);
		}
	}

	/** Op that computes the signum of a float value. */
	@Plugin(type = Ops.Math.Signum.class, priority = 0.2)
	public static class FloatSignum extends AbstractOp
		implements Ops.Math.Signum
	{
		@Parameter(type = ItemIO.OUTPUT)
		private float result;

		@Parameter
		private float a;

		@Override
		public void run() {
			result = Math.signum(a);
		}
	}

	/** Op that adds ({@literal +}) two double values. */
	@Plugin(type = Ops.Math.Add.class, priority = 0.1)
	public static class DoubleAdd extends AbstractOp
		implements Ops.Math.Add
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Parameter
		private double b;

		@Override
		public void run() {
			result = a + b;
		}
	}

	/** Op that subtracts ({@literal -}) two double values. */
	@Plugin(type = Ops.Math.Subtract.class, priority = 0.1)
	public static class DoubleSubtract extends AbstractOp
		implements Ops.Math.Subtract
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Parameter
		private double b;

		@Override
		public void run() {
			result = a - b;
		}
	}

	/** Op that multiplies ({@literal *}) two double values. */
	@Plugin(type = Ops.Math.Multiply.class, priority = 0.1)
	public static class DoubleMultiply extends AbstractOp
		implements Ops.Math.Multiply
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Parameter
		private double b;

		@Override
		public void run() {
			result = a * b;
		}
	}

	/** Op that divides ({@literal /}) two double values. */
	@Plugin(type = Ops.Math.Divide.class, priority = 0.1)
	public static class DoubleDivide extends AbstractOp
		implements Ops.Math.Divide
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Parameter
		private double b;

		@Override
		public void run() {
			result = a / b;
		}
	}

	/** Op that computes the remainder ({@literal %}) of two double values. */
	@Plugin(type = Ops.Math.Remainder.class, priority = 0.1)
	public static class DoubleRemainder extends AbstractOp
		implements Ops.Math.Remainder
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Parameter
		private double b;

		@Override
		public void run() {
			result = a % b;
		}
	}

	/** Op that computes the maximum of two double values. */
	@Plugin(type = Ops.Math.Max.class, priority = 0.1)
	public static class DoubleMax extends AbstractOp
		implements Ops.Math.Max
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Parameter
		private double b;

		@Override
		public void run() {
			result = Math.max(a, b);
		}
	}

	/** Op that computes the minimum of two double values. */
	@Plugin(type = Ops.Math.Min.class, priority = 0.1)
	public static class DoubleMin extends AbstractOp
		implements Ops.Math.Min
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Parameter
		private double b;

		@Override
		public void run() {
			result = Math.min(a, b);
		}
	}

	/** Op that exponentiate two double values. */
	@Plugin(type = Ops.Math.Power.class, priority = 0.1)
	public static class DoublePower extends AbstractOp
		implements Ops.Math.Power
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Parameter
		private double b;

		@Override
		public void run() {
			result = Math.pow(a, b);
		}
	}

	/** Op that negates ({@literal -}) a double value. */
	@Plugin(type = Ops.Math.Negate.class, priority = 0.1)
	public static class DoubleNegate extends AbstractOp
		implements Ops.Math.Negate
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = -a;
		}
	}

	/** Op that computes the absolute value of a double value. */
	@Plugin(type = Ops.Math.Abs.class, priority = 0.1)
	public static class DoubleAbs extends AbstractOp
		implements Ops.Math.Abs
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.abs(a);
		}
	}

	/** Op that computes the arccosine of a double value. */
	@Plugin(type = Ops.Math.Arccos.class, priority = 0.1)
	public static class DoubleArccos extends AbstractOp
		implements Ops.Math.Arccos
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.acos(a);
		}
	}

	/** Op that computes the arcsine of a double value. */
	@Plugin(type = Ops.Math.Arcsin.class, priority = 0.1)
	public static class DoubleArcsin extends AbstractOp
		implements Ops.Math.Arcsin
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.asin(a);
		}
	}

	/** Op that computes the arctangent of a double value. */
	@Plugin(type = Ops.Math.Arctan.class, priority = 0.1)
	public static class DoubleArctan extends AbstractOp
		implements Ops.Math.Arctan
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.atan(a);
		}
	}

	/** Op that computes the ceiling of a double value. */
	@Plugin(type = Ops.Math.Ceil.class, priority = 0.1)
	public static class DoubleCeil extends AbstractOp
		implements Ops.Math.Ceil
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.ceil(a);
		}
	}

	/** Op that computes the cosine of a double value. */
	@Plugin(type = Ops.Math.Cos.class, priority = 0.1)
	public static class DoubleCos extends AbstractOp
		implements Ops.Math.Cos
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.cos(a);
		}
	}

	/** Op that computes the hyperbolic cosine of a double value. */
	@Plugin(type = Ops.Math.Cosh.class, priority = 0.1)
	public static class DoubleCosh extends AbstractOp
		implements Ops.Math.Cosh
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.cosh(a);
		}
	}

	/** Op that computes the cubic root of a double value. */
	@Plugin(type = Ops.Math.CubeRoot.class, priority = 0.1)
	public static class DoubleCubeRoot extends AbstractOp
		implements Ops.Math.CubeRoot
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.cbrt(a);
		}
	}

	/** Op that computes the natural exponent of a double value. */
	@Plugin(type = Ops.Math.Exp.class, priority = 0.1)
	public static class DoubleExp extends AbstractOp
		implements Ops.Math.Exp
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.exp(a);
		}
	}

	/** Op that computes the floor of a double value. */
	@Plugin(type = Ops.Math.Floor.class, priority = 0.1)
	public static class DoubleFloor extends AbstractOp
		implements Ops.Math.Floor
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.floor(a);
		}
	}

	/** Op that computes the natural logarithm of a double value. */
	@Plugin(type = Ops.Math.Log.class, priority = 0.1)
	public static class DoubleLog extends AbstractOp
		implements Ops.Math.Log
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.log(a);
		}
	}

	/** Op that computes the base 10 logarithm of a double value. */
	@Plugin(type = Ops.Math.Log10.class, priority = 0.1)
	public static class DoubleLog10 extends AbstractOp
		implements Ops.Math.Log10
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.log10(a);
		}
	}

	/** Op that computes the natural logarithm of one plus a double value. */
	@Plugin(type = Ops.Math.LogOnePlusX.class, priority = 0.1)
	public static class DoubleLogOnePlusX extends AbstractOp
		implements Ops.Math.LogOnePlusX
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.log1p(a);
		}
	}

	/** Op that rounds a double value. */
	@Plugin(type = Ops.Math.Round.class, priority = 0.1)
	public static class DoubleRound extends AbstractOp
		implements Ops.Math.Round
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.round(a);
		}
	}

	/** Op that computes the signum of a double value. */
	@Plugin(type = Ops.Math.Signum.class, priority = 0.1)
	public static class DoubleSignum extends AbstractOp
		implements Ops.Math.Signum
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.signum(a);
		}
	}

	/** Op that computes the sine of a double value. */
	@Plugin(type = Ops.Math.Sin.class, priority = 0.1)
	public static class DoubleSin extends AbstractOp
		implements Ops.Math.Sin
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.sin(a);
		}
	}

	/** Op that computes the hyperbolic sine of a double value. */
	@Plugin(type = Ops.Math.Sinh.class, priority = 0.1)
	public static class DoubleSinh extends AbstractOp
		implements Ops.Math.Sinh
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.sinh(a);
		}
	}

	/** Op that computes the square root of a double value. */
	@Plugin(type = Ops.Math.Sqrt.class, priority = 0.1)
	public static class DoubleSqrt extends AbstractOp
		implements Ops.Math.Sqrt
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.sqrt(a);
		}
	}

	/** Op that computes the tangent of a double value. */
	@Plugin(type = Ops.Math.Tan.class, priority = 0.1)
	public static class DoubleTan extends AbstractOp
		implements Ops.Math.Tan
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.tan(a);
		}
	}

	/** Op that computes the hyperbolic tangent of a double value. */
	@Plugin(type = Ops.Math.Tanh.class, priority = 0.1)
	public static class DoubleTanh extends AbstractOp
		implements Ops.Math.Tanh
	{
		@Parameter(type = ItemIO.OUTPUT)
		private double result;

		@Parameter
		private double a;

		@Override
		public void run() {
			result = Math.tanh(a);
		}
	}

}
