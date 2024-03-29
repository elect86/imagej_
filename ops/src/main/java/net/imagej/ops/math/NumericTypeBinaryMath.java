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

import net.imagej.ops.Contingent;
import net.imagej.ops.Ops;
import net.imagej.ops.special.hybrid.AbstractBinaryHybridCFI;
import net.imglib2.type.numeric.NumericType;

import org.scijava.Priority;
import org.scijava.plugin.Plugin;

/**
 * Generated arithmetic ops with ImgLib2 {@link NumericType}s.
 *
 * @author Aparna Pal
 * @author Leon Yang
 * @author Curtis Rueden
 */
public final class NumericTypeBinaryMath {

	private NumericTypeBinaryMath() {
		// NB: Prevent instantiation of utility class.
	}

	@SuppressWarnings("rawtypes")
	private static boolean compatible(NumericType in1, NumericType in2,
		NumericType out)
	{
		if (out == null) {
			return in1 == null || in2 == null || in1.getClass() == in2.getClass();
		}
		return in1.getClass() == in2.getClass() && in1.getClass() == out.getClass();
	}

	/** Op that adds (+) two NumericType values. */
	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH)
	public static class Add<T extends NumericType<T>> extends
		AbstractBinaryHybridCFI<T, T> implements Ops.Math.Add, Contingent
	{

		@Override
		public boolean conforms() {
			return compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final T input1, final T input2, final T output) {
			output.set(input1);
			output.add(input2);
		}

		@Override
		public T createOutput(T input1, T input2) {
			return input1.createVariable();
		}

		@Override
		public void mutate1(final T arg, final T in) {
			final T result = arg.createVariable();
			compute(arg, in, result);
			arg.set(result);
		}

		@Override
		public void mutate2(final T in, final T arg) {
			final T result = arg.createVariable();
			compute(in, arg, result);
			arg.set(result);
		}

		@Override
		public Add<T> getIndependentInstance() {
			return this;
		}
	}

	/** Op that divides (/) two NumericType values. */
	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH)
	public static class Divide<T extends NumericType<T>> extends
		AbstractBinaryHybridCFI<T, T> implements Ops.Math.Divide, Contingent
	{

		@Override
		public boolean conforms() {
			return compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final T input1, final T input2, final T output) {
			output.set(input1);
			output.div(input2);
		}

		@Override
		public T createOutput(T input1, T input2) {
			return input1.createVariable();
		}

		@Override
		public void mutate1(final T arg, final T in) {
			final T result = arg.createVariable();
			compute(arg, in, result);
			arg.set(result);
		}

		@Override
		public void mutate2(final T in, final T arg) {
			final T result = arg.createVariable();
			compute(in, arg, result);
			arg.set(result);
		}

		@Override
		public Divide<T> getIndependentInstance() {
			return this;
		}
	}

	/** Op that subtracts (-) two NumericType values. */
	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH)
	public static class Subtract<T extends NumericType<T>> extends
		AbstractBinaryHybridCFI<T, T> implements Ops.Math.Subtract, Contingent
	{

		@Override
		public boolean conforms() {
			return compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final T input1, final T input2, final T output) {
			output.set(input1);
			output.sub(input2);
		}

		@Override
		public T createOutput(T input1, T input2) {
			return input1.createVariable();
		}

		@Override
		public void mutate1(final T arg, final T in) {
			final T result = arg.createVariable();
			compute(arg, in, result);
			arg.set(result);
		}

		@Override
		public void mutate2(final T in, final T arg) {
			final T result = arg.createVariable();
			compute(in, arg, result);
			arg.set(result);
		}

		@Override
		public Subtract<T> getIndependentInstance() {
			return this;
		}
	}

	/** Op that multiplies (*) two NumericType values. */
	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH)
	public static class Multiply<T extends NumericType<T>> extends
		AbstractBinaryHybridCFI<T, T> implements Ops.Math.Multiply, Contingent
	{

		@Override
		public boolean conforms() {
			return compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final T input1, final T input2, final T output) {
			output.set(input1);
			output.mul(input2);
		}

		@Override
		public T createOutput(T input1, T input2) {
			return input1.createVariable();
		}

		@Override
		public void mutate1(final T arg, final T in) {
			final T result = arg.createVariable();
			compute(arg, in, result);
			arg.set(result);
		}

		@Override
		public void mutate2(final T in, final T arg) {
			final T result = arg.createVariable();
			compute(in, arg, result);
			arg.set(result);
		}

		@Override
		public Multiply<T> getIndependentInstance() {
			return this;
		}
	}

}
