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
import net.imagej.ops.map.neighborhood.CenterAwareComputerOp;
import net.imagej.ops.special.computer.Computers;
import net.imagej.ops.special.computer.UnaryComputerOp;
import net.imagej.ops.threshold.apply.LocalThreshold;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.histogram.Histogram1d;
import net.imglib2.type.logic.BitType;
import net.imglib2.type.numeric.RealType;

import org.scijava.plugin.Plugin;

/**
 * Ops that apply a global threshold locally to a {@link RandomAccessibleInterval}.
 * 
 * @author Stefan Helfrich (University of Konstanz)
 */
public final class ApplyThresholdMethodLocal {

	private ApplyThresholdMethodLocal() {
		// NB: Prevent instantiation of utility class.
	}

	@Plugin(type = Ops.Threshold.Huang.class)
	public static class LocalHuangThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.Huang
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.Huang.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.IJ1.class)
	public static class LocalIJ1Threshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.IJ1
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.IJ1.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.Intermodes.class)
	public static class LocalIntermodesThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.Intermodes
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.Intermodes.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.IsoData.class)
	public static class LocalIsoDataThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.IsoData
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.IsoData.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.Li.class)
	public static class LocalLiThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.Li
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.Li.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.MaxEntropy.class)
	public static class LocalMaxEntropyThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.MaxEntropy
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.MaxEntropy.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.MaxLikelihood.class)
	public static class LocalMaxLikelihoodThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.MaxLikelihood
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.MaxLikelihood.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.MinError.class)
	public static class LocalMinErrorThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.MinError
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.MinError.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.Minimum.class)
	public static class LocalMinimumThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.Minimum
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.Minimum.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.Moments.class)
	public static class LocalMomentsThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.Moments
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.Moments.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.Otsu.class)
	public static class LocalOtsuThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.Otsu
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.Otsu.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.Percentile.class)
	public static class LocalPercentileThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.Percentile
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.Percentile.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.RenyiEntropy.class)
	public static class LocalRenyiEntropyThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.RenyiEntropy
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.RenyiEntropy.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.Rosin.class)
	public static class LocalRosinThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.Rosin
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.Rosin.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.Shanbhag.class)
	public static class LocalShanbhagThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.Shanbhag
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.Shanbhag.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.Triangle.class)
	public static class LocalTriangleThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.Triangle
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.Triangle.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

	@Plugin(type = Ops.Threshold.Yen.class)
	public static class LocalYenThreshold<T extends RealType<T>> extends
		LocalThreshold<T> implements Ops.Threshold.Yen
	{

		@Override
		protected CenterAwareComputerOp<T, BitType> unaryComputer(final T inClass,
			final BitType outClass)
		{
			final LocalThresholdMethodHistogram<T, BitType> op =
				new LocalThresholdMethodHistogram<T, BitType>()
			{
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				protected UnaryComputerOp<Histogram1d<T>, T>
					getThresholdComputer()
				{
					UnaryComputerOp unary = Computers.unary(ops(),
						Ops.Threshold.Yen.class, inClass.getClass(), Histogram1d.class);
					return unary;
				}
			};

			op.setEnvironment(ops());
			op.initialize();
			return op;
		}

	}

}
