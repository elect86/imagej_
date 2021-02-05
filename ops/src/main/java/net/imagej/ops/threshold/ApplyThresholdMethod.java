/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2014 - 2016 Board of Regents of the University of
 * Wisconsin-Madison and University of Konstanz.
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

package net.imagej.ops.threshold;

import net.imagej.ops.Ops;
import net.imagej.ops.special.computer.Computers;
import net.imagej.ops.special.computer.UnaryComputerOp;
import net.imglib2.histogram.Histogram1d;
import net.imglib2.IterableInterval;
import net.imglib2.img.Img;
import net.imglib2.type.numeric.RealType;

import org.scijava.plugin.Plugin;

/**
 * Ops which computes and apply a global threshold to an {@link Img}.
 * 
 * @author Christian Dietz (University of Konstanz)
 * @author Curtis Rueden
 * @author Brian Northan
 */
public final class ApplyThresholdMethod {

	private ApplyThresholdMethod() {
		// NB: Prevent instantiation of utility class.
	}

	@Plugin(type = Ops.Threshold.Huang.class)
	public static class Huang<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.Huang
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.Huang.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.IJ1.class)
	public static class IJ1<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.IJ1
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.IJ1.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.Intermodes.class)
	public static class Intermodes<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.Intermodes
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.Intermodes.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.IsoData.class)
	public static class IsoData<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.IsoData
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.IsoData.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.Li.class)
	public static class Li<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.Li
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.Li.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.MaxEntropy.class)
	public static class MaxEntropy<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.MaxEntropy
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.MaxEntropy.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.MaxLikelihood.class)
	public static class MaxLikelihood<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.MaxLikelihood
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.MaxLikelihood.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.Mean.class)
	public static class Mean<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.Mean
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.Mean.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.MinError.class)
	public static class MinError<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.MinError
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.MinError.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.Minimum.class)
	public static class Minimum<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.Minimum
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.Minimum.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.Moments.class)
	public static class Moments<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.Moments
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.Moments.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.Otsu.class)
	public static class Otsu<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.Otsu
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.Otsu.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.Percentile.class)
	public static class Percentile<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.Percentile
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.Percentile.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.RenyiEntropy.class)
	public static class RenyiEntropy<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.RenyiEntropy
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.RenyiEntropy.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.Rosin.class)
	public static class Rosin<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.Rosin
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.Rosin.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.Shanbhag.class)
	public static class Shanbhag<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.Shanbhag
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.Shanbhag.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.Triangle.class)
	public static class Triangle<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.Triangle
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.Triangle.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

	@Plugin(type = Ops.Threshold.Yen.class)
	public static class Yen<T extends RealType<T>>
		extends AbstractApplyThresholdImg<T>
		implements Ops.Threshold.Yen
	{

		private UnaryComputerOp<Histogram1d<T>, T> thresholdComp;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void initialize() {
			super.initialize();
			thresholdComp = (UnaryComputerOp) Computers.unary(ops(),
				Ops.Threshold.Yen.class, in().firstElement().getClass(),
				Histogram1d.class);
		}

		@Override
		public T getThreshold(final IterableInterval<T> input) {
			final Histogram1d<T> hist = histCreator.calculate(input);
			final T type = input.firstElement().createVariable();
			thresholdComp.compute(hist, type);
			return type;
		}
	}

}
