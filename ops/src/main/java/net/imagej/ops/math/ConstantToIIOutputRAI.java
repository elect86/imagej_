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

import net.imagej.ops.Ops;
import net.imagej.ops.special.computer.AbstractUnaryComputerOp;
import net.imglib2.Cursor;
import net.imglib2.IterableInterval;
import net.imglib2.RandomAccess;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.type.numeric.NumericType;

import org.scijava.Priority;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

/**
 * Wrapper class for functional binary math operations between constant values 
 * and {@link IterableInterval}s, and write the result
 * to {@link RandomAccessibleInterval}s.
 *
 * @author Leon Yang
 */
public final class ConstantToIIOutputRAI {

	private ConstantToIIOutputRAI() {
		// NB: Prevent instantiation of utility class.
	}

	@Plugin(type = Ops.Math.Add.class, priority = Priority.VERY_LOW)
	public static class Add<T extends NumericType<T>> extends
			AbstractUnaryComputerOp<IterableInterval<T>, RandomAccessibleInterval<T>>
			implements Ops.Math.Add {

		@Parameter
		private T value;

		@Override
		public void compute(final IterableInterval<T> input,
				final RandomAccessibleInterval<T> output) {
			final Cursor<T> c = input.localizingCursor();
			final RandomAccess<T> ra = output.randomAccess();
			while (c.hasNext()) {
				final T in = c.next();
				ra.setPosition(c);
				final T out = ra.get();
				out.set(in);
				out.add(value);
			}
		}

	}

	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.VERY_LOW)
	public static class Subtract<T extends NumericType<T>> extends
			AbstractUnaryComputerOp<IterableInterval<T>, RandomAccessibleInterval<T>>
			implements Ops.Math.Subtract {

		@Parameter
		private T value;

		@Override
		public void compute(final IterableInterval<T> input,
				final RandomAccessibleInterval<T> output) {
			final Cursor<T> c = input.localizingCursor();
			final RandomAccess<T> ra = output.randomAccess();
			while (c.hasNext()) {
				final T in = c.next();
				ra.setPosition(c);
				final T out = ra.get();
				out.set(in);
				out.sub(value);
			}
		}

	}

	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.VERY_LOW)
	public static class Multiply<T extends NumericType<T>> extends
			AbstractUnaryComputerOp<IterableInterval<T>, RandomAccessibleInterval<T>>
			implements Ops.Math.Multiply {

		@Parameter
		private T value;

		@Override
		public void compute(final IterableInterval<T> input,
				final RandomAccessibleInterval<T> output) {
			final Cursor<T> c = input.localizingCursor();
			final RandomAccess<T> ra = output.randomAccess();
			while (c.hasNext()) {
				final T in = c.next();
				ra.setPosition(c);
				final T out = ra.get();
				out.set(in);
				out.mul(value);
			}
		}

	}

	@Plugin(type = Ops.Math.Divide.class, priority = Priority.VERY_LOW)
	public static class Divide<T extends NumericType<T>> extends
			AbstractUnaryComputerOp<IterableInterval<T>, RandomAccessibleInterval<T>>
			implements Ops.Math.Divide {

		@Parameter
		private T value;

		@Override
		public void compute(final IterableInterval<T> input,
				final RandomAccessibleInterval<T> output) {
			final Cursor<T> c = input.localizingCursor();
			final RandomAccess<T> ra = output.randomAccess();
			while (c.hasNext()) {
				final T in = c.next();
				ra.setPosition(c);
				final T out = ra.get();
				out.set(in);
				out.div(value);
			}
		}

	}
}
