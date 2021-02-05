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

package net.imagej.ops;

import net.imagej.ops.Op;

/**
 * Static utility class containing built-in op interfaces.
 * <p>
 * These interfaces are intended to mark all ops using a particular name,
 * regardless of their exact functionality. For example, all ops called "eval"
 * would be marked by implementing the {@code Ops.Eval} interface, and
 * annotating them with:
 * </p>
 *
 * {@code @Plugin(type = Ops.Eval.class)}
 *
 * @author Curtis Rueden
 * @author Christian Dietz (University of Konstanz)
 * @author Brian Northan
 * @author Jonathan Hale (University of Konstanz)
 * @author Richard Domander (Royal Veterinary College, London)
 */
public final class Ops {

	private Ops() {
		// NB: Prevent instantiation of utility class.
	}

	/**
	 * Base interface for "eval" operations.
	 * <p>
	 * Implementing classes should be annotated with:
	 * </p>
	 *
	 * {@code @Plugin(type = Ops.Eval.class)}
	 */
	public interface Eval extends Op {
		String NAME = "eval";
	}

	/**
	 * Base interface for "help" operations.
	 * <p>
	 * Implementing classes should be annotated with:
	 * </p>
	 *
	 * {@code @Plugin(type = Ops.Help.class)}
	 */
	public interface Help extends Op {
		String NAME = "help";
	}

	/**
	 * Base interface for "identity" operations.
	 * <p>
	 * Implementing classes should be annotated with:
	 * </p>
	 *
	 * {@code @Plugin(type = Ops.Identity.class)}
	 */
	public interface Identity extends Op {
		String NAME = "identity";
	}

	/**
	 * Base interface for "join" operations.
	 * <p>
	 * Implementing classes should be annotated with:
	 * </p>
	 *
	 * {@code @Plugin(type = Ops.Join.class)}
	 */
	public interface Join extends Op {
		String NAME = "join";
	}

	/**
	 * Base interface for "loop" operations.
	 * <p>
	 * Implementing classes should be annotated with:
	 * </p>
	 *
	 * {@code @Plugin(type = Ops.Loop.class)}
	 */
	public interface Loop extends Op {
		String NAME = "loop";
	}

	/**
	 * Base interface for "map" operations.
	 * <p>
	 * Implementing classes should be annotated with:
	 * </p>
	 *
	 * {@code @Plugin(type = Ops.Map.class)}
	 */
	public interface Map extends Op {
		String NAME = "map";
	}

	/**
	 * Base interface for "op" operations.
	 * <p>
	 * Implementing classes should be annotated with:
	 * </p>
	 *
	 * {@code @Plugin(type = Ops.Lookup.class)}
	 */
	public interface Lookup extends Op {
		String NAME = "op";
	}

	/**
	 * Base interface for "run" operations.
	 * <p>
	 * Implementing classes should be annotated with:
	 * </p>
	 *
	 * {@code @Plugin(type = Ops.Run.class)}
	 */
	public interface Run extends Op {
		String NAME = "run";
	}

	/**
	 * Base interface for "slice" operations.
	 * <p>
	 * Implementing classes should be annotated with:
	 * </p>
	 *
	 * {@code @Plugin(type = Ops.Slice.class)}
	 */
	public interface Slice extends Op {
		String NAME = "slice";
	}

	/** Built-in op interfaces of the coloc namespace. */
	public static final class Coloc {

		private Coloc() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "costes" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Coloc.Costes.class)}
		 */
		public interface Costes extends Op {
			String NAME = "coloc.costes";
		}

		/**
		 * Base interface for "icq" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Coloc.ICQ.class)}
		 */
		public interface ICQ extends Op {
			String NAME = "coloc.icq";
		}

		/**
		 * Base interface for "kendallTau" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Coloc.KendallTau.class)}
		 */
		public interface KendallTau extends Op {
			String NAME = "coloc.kendallTau";
		}

		/**
		 * Base interface for "manders" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Coloc.Manders.class)}
		 */
		public interface Manders extends Op {
			String NAME = "coloc.manders";
		}

		/**
		 * Base interface for "maxTKendallTau" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Coloc.MaxTKendallTau.class)}
		 */
		public interface MaxTKendallTau extends Op {
			String NAME = "coloc.maxTKendallTau";
		}

		/**
		 * Base interface for "pearsons" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Coloc.Pearsons.class)}
		 */
		public interface Pearsons extends Op {
			String NAME = "coloc.pearsons";
		}

		/**
		 * Base interface for "pValue" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Coloc.PValue.class)}
		 */
		public interface PValue extends Op {
			String NAME = "coloc.pValue";
		}

		/**
		 * Base interface for "spearman" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Coloc.Spearman.class)}
		 */
		public interface Spearman extends Op {
			String NAME = "coloc.spearman";
		}
	}

	/** Built-in op interfaces of the convert namespace. */
	public static final class Convert {

		private Convert() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "bit" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Bit.class)}
		 */
		public interface Bit extends Op {
			String NAME = "convert.bit";
		}

		/**
		 * Base interface for "cfloat32" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Cfloat32.class)}
		 */
		public interface Cfloat32 extends Op {
			String NAME = "convert.cfloat32";
			String ALIASES = "convert.complexFloat";
		}

		/**
		 * Base interface for "cfloat64" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Cfloat64.class)}
		 */
		public interface Cfloat64 extends Op {
			String NAME = "convert.cfloat64";
			String ALIASES = "convert.complexDouble";
		}

		/**
		 * Base interface for "clip" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Clip.class)}
		 */
		public interface Clip extends Op {
			String NAME = "convert.clip";
		}

		/**
		 * Base interface for "copy" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Copy.class)}
		 */
		public interface Copy extends Op {
			String NAME = "convert.copy";
		}

		/**
		 * Base interface for "float32" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Float32.class)}
		 */
		public interface Float32 extends Op {
			String NAME = "convert.float32";
			String ALIASES = "convert.float";
		}

		/**
		 * Base interface for "float64" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Float64.class)}
		 */
		public interface Float64 extends Op {
			String NAME = "convert.float64";
			String ALIASES = "convert.double";
		}

		/**
		 * Base interface for "imageType" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.ImageType.class)}
		 */
		public interface ImageType extends Op {
			String NAME = "convert.imageType";
		}

		/**
		 * Base interface for "int16" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Int16.class)}
		 */
		public interface Int16 extends Op {
			String NAME = "convert.int16";
			String ALIASES = "convert.short";
		}

		/**
		 * Base interface for "int32" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Int32.class)}
		 */
		public interface Int32 extends Op {
			String NAME = "convert.int32";
			String ALIASES = "convert.int";
		}

		/**
		 * Base interface for "int64" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Int64.class)}
		 */
		public interface Int64 extends Op {
			String NAME = "convert.int64";
			String ALIASES = "convert.long";
		}

		/**
		 * Base interface for "int8" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Int8.class)}
		 */
		public interface Int8 extends Op {
			String NAME = "convert.int8";
			String ALIASES = "convert.byte";
		}

		/**
		 * Base interface for "normalizeScale" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.NormalizeScale.class)}
		 */
		public interface NormalizeScale extends Op {
			String NAME = "convert.normalizeScale";
		}

		/**
		 * Base interface for "scale" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Scale.class)}
		 */
		public interface Scale extends Op {
			String NAME = "convert.scale";
		}

		/**
		 * Base interface for "uint12" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Uint12.class)}
		 */
		public interface Uint12 extends Op {
			String NAME = "convert.uint12";
		}

		/**
		 * Base interface for "uint128" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Uint128.class)}
		 */
		public interface Uint128 extends Op {
			String NAME = "convert.uint128";
		}

		/**
		 * Base interface for "uint16" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Uint16.class)}
		 */
		public interface Uint16 extends Op {
			String NAME = "convert.uint16";
			String ALIASES = "convert.unsignedShort";
		}

		/**
		 * Base interface for "uint2" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Uint2.class)}
		 */
		public interface Uint2 extends Op {
			String NAME = "convert.uint2";
		}

		/**
		 * Base interface for "uint32" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Uint32.class)}
		 */
		public interface Uint32 extends Op {
			String NAME = "convert.uint32";
			String ALIASES = "convert.unsignedInt";
		}

		/**
		 * Base interface for "uint4" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Uint4.class)}
		 */
		public interface Uint4 extends Op {
			String NAME = "convert.uint4";
		}

		/**
		 * Base interface for "uint64" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Uint64.class)}
		 */
		public interface Uint64 extends Op {
			String NAME = "convert.uint64";
			String ALIASES = "convert.unsignedLong";
		}

		/**
		 * Base interface for "uint8" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Convert.Uint8.class)}
		 */
		public interface Uint8 extends Op {
			String NAME = "convert.uint8";
			String ALIASES = "convert.unsignedByte";
		}
	}

	/** Built-in op interfaces of the copy namespace. */
	public static final class Copy {

		private Copy() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "img" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Copy.Img.class)}
		 */
		public interface Img extends Op {
			String NAME = "copy.img";
		}

		/**
		 * Base interface for "imgLabeling" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Copy.ImgLabeling.class)}
		 */
		public interface ImgLabeling extends Op {
			String NAME = "copy.imgLabeling";
		}

		/**
		 * Base interface for "imgPlus" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Copy.ImgPlus.class)}
		 */
		public interface ImgPlus extends Op {
			String NAME = "copy.imgPlus";
		}

		/**
		 * Base interface for "iterableInterval" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Copy.IterableInterval.class)}
		 */
		public interface IterableInterval extends Op {
			String NAME = "copy.iterableInterval";
		}

		/**
		 * Base interface for "labelingMapping" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Copy.LabelingMapping.class)}
		 */
		public interface LabelingMapping extends Op {
			String NAME = "copy.labelingMapping";
		}

		/**
		 * Base interface for "rai" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Copy.RAI.class)}
		 */
		public interface RAI extends Op {
			String NAME = "copy.rai";
		}

		/**
		 * Base interface for "type" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Copy.Type.class)}
		 */
		public interface Type extends Op {
			String NAME = "copy.type";
		}
	}

	/** Built-in op interfaces of the create namespace. */
	public static final class Create {

		private Create() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "img" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.Img.class)}
		 */
		public interface Img extends Op {
			String NAME = "create.img";
		}

		/**
		 * Base interface for "imgFactory" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.ImgFactory.class)}
		 */
		public interface ImgFactory extends Op {
			String NAME = "create.imgFactory";
		}

		/**
		 * Base interface for "imgLabeling" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.ImgLabeling.class)}
		 */
		public interface ImgLabeling extends Op {
			String NAME = "create.imgLabeling";
		}

		/**
		 * Base interface for "imgPlus" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.ImgPlus.class)}
		 */
		public interface ImgPlus extends Op {
			String NAME = "create.imgPlus";
		}

		/**
		 * Base interface for "integerType" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.IntegerType.class)}
		 */
		public interface IntegerType extends Op {
			String NAME = "create.integerType";
		}

		/**
		 * Base interface for "kernel" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.Kernel.class)}
		 */
		public interface Kernel extends Op {
			String NAME = "create.kernel";
		}

		/**
		 * Base interface for "kernelGauss" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.KernelGauss.class)}
		 */
		public interface KernelGauss extends Op {
			String NAME = "create.kernelGauss";
		}

		/**
		 * Base interface for "kernelLog" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.KernelLog.class)}
		 */
		public interface KernelLog extends Op {
			String NAME = "create.kernelLog";
		}

		/**
		 * Base interface for "kernelBiGauss" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.KernelBiGauss.class)}
		 */
		public interface KernelBiGauss extends Op {
			String NAME = "create.kernelBiGauss";
		}

		/**
		 * Base interface for "kernel2ndDerivBiGauss" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.Kernel2ndDerivBiGauss.class)}
		 */
		public interface Kernel2ndDerivBiGauss extends Op {
			String NAME = "create.kernel2ndDerivBiGauss";
		}

		/**
		 * Base interface for "kernelDiffraction" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.KernelDiffraction.class)}
		 */
		public interface KernelDiffraction extends Op {
			String NAME = "create.kernelDiffraction";
		}

		/**
		 * Base interface for "kernelGabor" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.KernelGabor.class)}
		 */
		public interface KernelGabor extends Op {
			String NAME = "create.kernelGabor";
		}

		/**
		 * Base interface for "kernelSobel" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.KernelSobel.class)}
		 */
		public interface KernelSobel extends Op {
			String NAME = "create.kernelSobel";
		}

		/**
		 * Base interface for "labelingMapping" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.LabelingMapping.class)}
		 */
		public interface LabelingMapping extends Op {
			String NAME = "create.labelingMapping";
		}

		/**
		 * Base interface for "nativeImg" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.NativeImg.class)}
		 */
		public interface NativeImg extends Op {
			String NAME = "create.nativeImg";
		}

		/**
		 * Base interface for "nativeType" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.NativeType.class)}
		 */
		public interface NativeType extends Op {
			String NAME = "create.nativeType";
		}

		/**
		 * Base interface for "object" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.Object.class)}
		 */
		public interface Object extends Op {
			String NAME = "create.object";
		}

		/**
		 * Base interface for "type" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Create.Type.class)}
		 */
		public interface Type extends Op {
			String NAME = "create.type";
		}
	}

	/** Built-in op interfaces of the deconvolve namespace. */
	public static final class Deconvolve {

		private Deconvolve() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "accelerate" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Deconvolve.Accelerate.class)}
		 */
		public interface Accelerate extends Op {
			String NAME = "deconvolve.accelerate";
		}

		/**
		 * Base interface for "firstGuess" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Deconvolve.FirstGuess.class)}
		 */
		public interface FirstGuess extends Op {
			String NAME = "deconvolve.firstGuess";
		}

		/**
		 * Base interface for "normalizationFactor" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Deconvolve.NormalizationFactor.class)}
		 */
		public interface NormalizationFactor extends Op {
			String NAME = "deconvolve.normalizationFactor";
		}

		/**
		 * Base interface for "richardsonLucy" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Deconvolve.RichardsonLucy.class)}
		 */
		public interface RichardsonLucy extends Op {
			String NAME = "deconvolve.richardsonLucy";
		}

		/**
		 * Base interface for "richardsonLucyCorrection" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Deconvolve.RichardsonLucyCorrection.class)}
		 */
		public interface RichardsonLucyCorrection extends Op {
			String NAME = "deconvolve.richardsonLucyCorrection";
		}

		/**
		 * Base interface for "richardsonLucyTV" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Deconvolve.RichardsonLucyTV.class)}
		 */
		public interface RichardsonLucyTV extends Op {
			String NAME = "deconvolve.richardsonLucyTV";
		}

		/**
		 * Base interface for "richardsonLucyUpdate" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Deconvolve.RichardsonLucyUpdate.class)}
		 */
		public interface RichardsonLucyUpdate extends Op {
			String NAME = "deconvolve.richardsonLucyUpdate";
		}
	}

	/** Built-in op interfaces of the filter namespace. */
	public static final class Filter {

		private Filter() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "addNoise" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.AddNoise.class)}
		 */
		public interface AddNoise extends Op {
			String NAME = "filter.addNoise";
		}

		/**
		 * Base interface for "addPoissonNoise" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.AddPoissonNoise.class)}
		 */
		public interface AddPoissonNoise extends Op {
			String NAME = "filter.addPoissonNoise";
		}

		/**
		 * Base interface for "bilateral" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Bilateral.class)}
		 */
		public interface Bilateral extends Op {
			String NAME = "filter.bilateral";
		}

		/**
		 * Base interface for "convolve" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Convolve.class)}
		 */
		public interface Convolve extends Op {
			String NAME = "filter.convolve";
		}

		/**
		 * Base interface for "correlate" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Correlate.class)}
		 */
		public interface Correlate extends Op {
			String NAME = "filter.correlate";
		}

		/**
		 * Base interface for "createFFTOutput" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.CreateFFTOutput.class)}
		 */
		public interface CreateFFTOutput extends Op {
			String NAME = "filter.createFFTOutput";
		}

		/**
		 * Base interface for "partialDerivative" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.PartialDerivative.class)}
		 */
		public interface PartialDerivative extends Op {
			String NAME = "filter.partialDerivative";
		}

		/**
		 * Base interface for "allPartialDerivatives" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.AllPartialDerivatives.class)}
		 */
		public interface AllPartialDerivatives extends Op {
			String NAME = "filter.allPartialDerivatives";
		}

		/**
		 * Base interface for "derivativeGauss" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.DerivativeGauss.class)}
		 */
		public interface DerivativeGauss extends Op {
			String NAME = "filter.derivativeGauss";
		}

		/**
		 * Base interface for "dog" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.DoG.class)}
		 */
		public interface DoG extends Op {
			String NAME = "filter.dog";
			String ALIASES = "filter.differenceOfGaussian";
		}

		/**
		 * Base interface for "fft" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.FFT.class)}
		 */
		public interface FFT extends Op {
			String NAME = "filter.fft";
		}

		/**
		 * Base interface for "fftSize" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.FFTSize.class)}
		 */
		public interface FFTSize extends Op {
			String NAME = "filter.fftSize";
		}

		/**
		 * Base interface for "gauss" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Gauss.class)}
		 */
		public interface Gauss extends Op {
			String NAME = "filter.gauss";
			String ALIASES = "filter.smooth";
		}

		/**
		 * Base interface for "hessian" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Hessian.class)}
		 */
		public interface Hessian extends Op {
			String NAME = "filter.hessian";
		}

		/**
		 * Base interface for "ifft" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.IFFT.class)}
		 */
		public interface IFFT extends Op {
			String NAME = "filter.ifft";
		}

		/**
		 * Base interface for "linearFilter" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.LinearFilter.class)}
		 */
		public interface LinearFilter extends Op {
			String NAME = "filter.linearFilter";
		}

		/**
		 * Base interface for "max" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Max.class)}
		 */
		public interface Max extends Op {
			String NAME = "filter.max";
			String ALIASES = "filter.maxFilter, filter.filterMax";
		}

		/**
		 * Base interface for "mean" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Mean.class)}
		 */
		public interface Mean extends Op {
			String NAME = "filter.mean";
			String ALIASES = "filter.meanFilter, filter.filterMean";
		}

		/**
		 * Base interface for "median" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Median.class)}
		 */
		public interface Median extends Op {
			String NAME = "filter.median";
			String ALIASES = "filter.medianFilter, filter.filterMedian";
		}

		/**
		 * Base interface for "min" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Min.class)}
		 */
		public interface Min extends Op {
			String NAME = "filter.min";
			String ALIASES = "filter.minFilter, filter.filterMin";
		}

		/**
		 * Base interface for "padFFTInput" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.PadFFTInput.class)}
		 */
		public interface PadFFTInput extends Op {
			String NAME = "filter.padFFTInput";
		}

		/**
		 * Base interface for "padInput" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.PadInput.class)}
		 */
		public interface PadInput extends Op {
			String NAME = "filter.padInput";
		}

		/**
		 * Base interface for "padShiftFFTKernel" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.PadShiftFFTKernel.class)}
		 */
		public interface PadShiftFFTKernel extends Op {
			String NAME = "filter.padShiftFFTKernel";
		}

		/**
		 * Base interface for "paddingIntervalCentered" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.PaddingIntervalCentered.class)}
		 */
		public interface PaddingIntervalCentered extends Op {
			String NAME = "filter.paddingIntervalCentered";
		}

		/**
		 * Base interface for "paddingIntervalOrigin" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.PaddingIntervalOrigin.class)}
		 */
		public interface PaddingIntervalOrigin extends Op {
			String NAME = "filter.paddingIntervalOrigin";
		}

		/**
		 * Base interface for "tubeness" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Tubeness.class)}
		 */
		public interface Tubeness extends Op {
			String NAME = "filter.tubeness";
		}

		/**
		 * Base interface for "sigma" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Sigma.class)}
		 */
		public interface Sigma extends Op {
			String NAME = "filter.sigma";
			String ALIASES = "filter.sigmaFilter, filter.filterSigma";
		}

		/**
		 * Base interface for "sobel" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Sobel.class)}
		 */
		public interface Sobel extends Op {
			String NAME = "filter.sobel";
		}

		/**
		 * Base interface for "variance" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.Variance.class)}
		 */
		public interface Variance extends Op {
			String NAME = "filter.variance";
			String ALIASES = "filter.varianceFilter, filter.filterVariance, filter.var, filter.varFilter, filter.filterVar";
		}

		/**
		 * Base interface for "frangiVesselness" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Filter.FrangiVesselness.class)}
		 */
		public interface FrangiVesselness extends Op {
			String NAME = "filter.frangiVesselness";
		}
	}

	/** Built-in op interfaces of the geom namespace. */
	public static final class Geometric {

		private Geometric() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "boundary" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Boundary.class)}
		 */
		public interface Boundary extends Op {
			String NAME = "geom.boundary";
		}

		/**
		 * Base interface for "boundaryConvexHull" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.BoundaryConvexHull.class)}
		 */
		public interface BoundaryConvexHull extends Op {
			String NAME = "geom.boundaryConvexHull";
		}

		/**
		 * Base interface for "verticesCount" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.VerticesCount.class)}
		 */
		public interface VerticesCount extends Op {
			String NAME = "geom.verticesCount";
		}

		/**
		 * Base interface for "verticesCountConvexHull" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.VerticesCountConvexHull.class)}
		 */
		public interface VerticesCountConvexHull extends Op {
			String NAME = "geom.verticesCountConvexHull";
		}

		/**
		 * Base interface for "boundarySize" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.BoundarySize.class)}
		 */
		public interface BoundarySize extends Op {
			String NAME = "geom.boundarySize";
		}

		/**
		 * Base interface for "boundarySizeConvexHull" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.BoundarySizeConvexHull.class)}
		 */
		public interface BoundarySizeConvexHull extends Op {
			String NAME = "geom.boundarySizeConvexHull";
		}

		/**
		 * Base interface for "boundingBox" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.BoundingBox.class)}
		 */
		public interface BoundingBox extends Op {
			String NAME = "geom.boundingBox";
		}

		/**
		 * Base interface for "boxivity" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Boxivity.class)}
		 */
		public interface Boxivity extends Op {
			String NAME = "geom.boxivity";
		}

		/**
		 * Base interface for "centerOfGravity" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.CenterOfGravity.class)}
		 */
		public interface CenterOfGravity extends Op {
			String NAME = "geom.centerOfGravity";
		}

		/**
		 * Base interface for "centroid" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Centroid.class)}
		 */
		public interface Centroid extends Op {
			String NAME = "geom.centroid";
		}

		/**
		 * Base interface for "circularity" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Circularity.class)}
		 */
		public interface Circularity extends Op {
			String NAME = "geom.circularity";
		}

		/**
		 * Base interface for "compactness" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Compactness.class)}
		 */
		public interface Compactness extends Op {
			String NAME = "geom.compactness";
		}

		/**
		 * Base interface for "contour" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Contour.class)}
		 */
		public interface Contour extends Op {
			String NAME = "geom.contour";
		}

		/**
		 * Base interface for "convexHull" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.ConvexHull.class)}
		 */
		public interface ConvexHull extends Op {
			String NAME = "geom.convexHull";
		}

		/**
		 * Base interface for "convexity" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Convexity.class)}
		 */
		public interface Convexity extends Op {
			String NAME = "geom.convexity";
		}

		/**
		 * Base interface for "eccentricity" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Eccentricity.class)}
		 */
		public interface Eccentricity extends Op {
			String NAME = "geom.eccentricity";
		}

		/**
		 * Base interface for "maximumFeret" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.MaximumFeret.class)}
		 */
		public interface MaximumFeret extends Op {
			String NAME = "geom.maximumFeret";
		}

		/**
		 * Base interface for "minimumFeret" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.MinimumFeret.class)}
		 */
		public interface MinimumFeret extends Op {
			String NAME = "geom.minimumFeret";
		}

		/**
		 * Base interface for "feretsAngle" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.FeretsAngle.class)}
		 */
		public interface FeretsAngle extends Op {
			String NAME = "geom.feretsAngle";
		}

		/**
		 * Base interface for "maximumFeretsAngle" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.MaximumFeretsAngle.class)}
		 */
		public interface MaximumFeretsAngle extends Op {
			String NAME = "geom.maximumFeretsAngle";
		}

		/**
		 * Base interface for "minimumFeretsAngle" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.MinimumFeretsAngle.class)}
		 */
		public interface MinimumFeretsAngle extends Op {
			String NAME = "geom.minimumFeretsAngle";
		}

		/**
		 * Base interface for "feretsDiameter" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.FeretsDiameter.class)}
		 */
		public interface FeretsDiameter extends Op {
			String NAME = "geom.feretsDiameter";
		}

		/**
		 * Base interface for "maximumFeretsDiameter" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.MaximumFeretsDiameter.class)}
		 */
		public interface MaximumFeretsDiameter extends Op {
			String NAME = "geom.maximumFeretsDiameter";
		}

		/**
		 * Base interface for "minimumFeretsDiameter" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.MinimumFeretsDiameter.class)}
		 */
		public interface MinimumFeretsDiameter extends Op {
			String NAME = "geom.minimumFeretsDiameter";
		}

		/**
		 * Base interface for "mainElongation" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.MainElongation.class)}
		 */
		public interface MainElongation extends Op {
			String NAME = "geom.mainElongation";
		}

		/**
		 * Base interface for "majorAxis" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.MajorAxis.class)}
		 */
		public interface MajorAxis extends Op {
			String NAME = "geom.majorAxis";
		}

		/**
		 * Base interface for "marchingCubes" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.MarchingCubes.class)}
		 */
		public interface MarchingCubes extends Op {
			String NAME = "geom.marchingCubes";
		}

		/**
		 * Base interface for "medianElongation" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.MedianElongation.class)}
		 */
		public interface MedianElongation extends Op {
			String NAME = "geom.medianElongation";
		}

		/**
		 * Base interface for "minorAxis" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.MinorAxis.class)}
		 */
		public interface MinorAxis extends Op {
			String NAME = "geom.minorAxis";
		}

		/**
		 * Base interface for "roundness" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Roundness.class)}
		 */
		public interface Roundness extends Op {
			String NAME = "geom.roundness";
		}

		/**
		 * Base interface for "secondMoment" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.SecondMoment.class)}
		 */
		public interface SecondMoment extends Op {
			String NAME = "geom.secondMoment";
		}

		/**
		 * Base interface for "size" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Size.class)}
		 */
		public interface Size extends Op {
			String NAME = "geom.size";
		}

		/**
		 * Base interface for "sizeConvexHull" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.SizeConvexHull.class)}
		 */
		public interface SizeConvexHull extends Op {
			String NAME = "geom.sizeConvexHull";
		}

		/**
		 * Base interface for "smallestEnclosingBoundingBox" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.SmallestEnclosingBoundingBox.class)}
		 */
		public interface SmallestEnclosingBoundingBox extends Op {
			String NAME = "geom.smallestEnclosingBoundingBox";
		}

		/**
		 * Base interface for "solidity" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Solidity.class)}
		 */
		public interface Solidity extends Op {
			String NAME = "geom.solidity";
		}

		/**
		 * Base interface for "spareness" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Spareness.class)}
		 */
		public interface Spareness extends Op {
			String NAME = "geom.spareness";
		}

		/**
		 * Base interface for "sphericity" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Sphericity.class)}
		 */
		public interface Sphericity extends Op {
			String NAME = "geom.sphericity";
		}

		/**
		 * Base interface for "vertexInterpolator" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.VertexInterpolator.class)}
		 */
		public interface VertexInterpolator extends Op {
			String NAME = "geom.vertexInterpolator";
		}

		/**
		 * Base interface for "voxelization" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Geometric.Voxelization.class)}
		 */
		public interface Voxelization extends Op {
			String NAME = "geom.voxelization";
		}
	}

	/** Built-in op interfaces of the haralick namespace. */
	public static final class Haralick {

		private Haralick() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "asm" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.ASM.class)}
		 */
		public interface ASM extends Op {
			String NAME = "haralick.asm";
		}

		/**
		 * Base interface for "clusterPromenence" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.ClusterPromenence.class)}
		 */
		public interface ClusterPromenence extends Op {
			String NAME = "haralick.clusterPromenence";
		}

		/**
		 * Base interface for "clusterShade" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.ClusterShade.class)}
		 */
		public interface ClusterShade extends Op {
			String NAME = "haralick.clusterShade";
		}

		/**
		 * Base interface for "contrast" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.Contrast.class)}
		 */
		public interface Contrast extends Op {
			String NAME = "haralick.contrast";
		}

		/**
		 * Base interface for "correlation" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.Correlation.class)}
		 */
		public interface Correlation extends Op {
			String NAME = "haralick.correlation";
		}

		/**
		 * Base interface for "differenceEntropy" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.DifferenceEntropy.class)}
		 */
		public interface DifferenceEntropy extends Op {
			String NAME = "haralick.differenceEntropy";
		}

		/**
		 * Base interface for "differenceVariance" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.DifferenceVariance.class)}
		 */
		public interface DifferenceVariance extends Op {
			String NAME = "haralick.differenceVariance";
		}

		/**
		 * Base interface for "entropy" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.Entropy.class)}
		 */
		public interface Entropy extends Op {
			String NAME = "haralick.entropy";
		}

		/**
		 * Base interface for "icm1" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.ICM1.class)}
		 */
		public interface ICM1 extends Op {
			String NAME = "haralick.icm1";
		}

		/**
		 * Base interface for "icm2" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.ICM2.class)}
		 */
		public interface ICM2 extends Op {
			String NAME = "haralick.icm2";
		}

		/**
		 * Base interface for "ifdm" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.IFDM.class)}
		 */
		public interface IFDM extends Op {
			String NAME = "haralick.ifdm";
		}

		/**
		 * Base interface for "maxProbability" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.MaxProbability.class)}
		 */
		public interface MaxProbability extends Op {
			String NAME = "haralick.maxProbability";
		}

		/**
		 * Base interface for "sumAverage" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.SumAverage.class)}
		 */
		public interface SumAverage extends Op {
			String NAME = "haralick.sumAverage";
		}

		/**
		 * Base interface for "sumEntropy" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.SumEntropy.class)}
		 */
		public interface SumEntropy extends Op {
			String NAME = "haralick.sumEntropy";
		}

		/**
		 * Base interface for "sumVariance" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.SumVariance.class)}
		 */
		public interface SumVariance extends Op {
			String NAME = "haralick.sumVariance";
		}

		/**
		 * Base interface for "textureHomogeneity" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.TextureHomogeneity.class)}
		 */
		public interface TextureHomogeneity extends Op {
			String NAME = "haralick.textureHomogeneity";
		}

		/**
		 * Base interface for "variance" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Haralick.Variance.class)}
		 */
		public interface Variance extends Op {
			String NAME = "haralick.variance";
		}
	}

	/** Built-in op interfaces of the hog namespace. */
	public static final class HoG {

		private HoG() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "hog" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.HoG.HistogramOfOrientedGradients.class)}
		 */
		public interface HistogramOfOrientedGradients extends Op {
			String NAME = "hog.hog";
		}
	}

	/** Built-in op interfaces of the image namespace. */
	public static final class Image {

		private Image() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "ascii" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Image.ASCII.class)}
		 */
		public interface ASCII extends Op {
			String NAME = "image.ascii";
		}

		/**
		 * Base interface for "cooccurrenceMatrix" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Image.CooccurrenceMatrix.class)}
		 */
		public interface CooccurrenceMatrix extends Op {
			String NAME = "image.cooccurrenceMatrix";
		}

		/**
		 * Base interface for "distancetransform" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Image.DistanceTransform.class)}
		 */
		public interface DistanceTransform extends Op {
			String NAME = "image.distancetransform";
			String ALIASES = "image.DistanceMap";
		}

		/**
		 * Base interface for "equation" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Image.Equation.class)}
		 */
		public interface Equation extends Op {
			String NAME = "image.equation";
		}

		/**
		 * Base interface for "fill" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Image.Fill.class)}
		 */
		public interface Fill extends Op {
			String NAME = "image.fill";
		}

		/**
		 * Base interface for "histogram" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Image.Histogram.class)}
		 */
		public interface Histogram extends Op {
			String NAME = "image.histogram";
		}

		/**
		 * Base interface for "integral" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Image.Integral.class)}
		 */
		public interface Integral extends Op {
			String NAME = "image.integral";
		}

		/**
		 * Base interface for "invert" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Image.Invert.class)}
		 */
		public interface Invert extends Op {
			String NAME = "image.invert";
		}

		/**
		 * Base interface for "normalize" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Image.Normalize.class)}
		 */
		public interface Normalize extends Op {
			String NAME = "image.normalize";
			String ALIASES = "image.norm";
		}

		/**
		 * Base interface for "squareIntegral" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Image.SquareIntegral.class)}
		 */
		public interface SquareIntegral extends Op {
			String NAME = "image.squareIntegral";
		}

		/**
		 * Base interface for "watershed" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Image.Watershed.class)}
		 */
		public interface Watershed extends Op {
			String NAME = "image.watershed";
		}
	}

	/** Built-in op interfaces of the imagemoments namespace. */
	public static final class ImageMoments {

		private ImageMoments() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "centralMoment00" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.CentralMoment00.class)}
		 */
		public interface CentralMoment00 extends Op {
			String NAME = "imagemoments.centralMoment00";
		}

		/**
		 * Base interface for "centralMoment01" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.CentralMoment01.class)}
		 */
		public interface CentralMoment01 extends Op {
			String NAME = "imagemoments.centralMoment01";
		}

		/**
		 * Base interface for "centralMoment02" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.CentralMoment02.class)}
		 */
		public interface CentralMoment02 extends Op {
			String NAME = "imagemoments.centralMoment02";
		}

		/**
		 * Base interface for "centralMoment03" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.CentralMoment03.class)}
		 */
		public interface CentralMoment03 extends Op {
			String NAME = "imagemoments.centralMoment03";
		}

		/**
		 * Base interface for "centralMoment10" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.CentralMoment10.class)}
		 */
		public interface CentralMoment10 extends Op {
			String NAME = "imagemoments.centralMoment10";
		}

		/**
		 * Base interface for "centralMoment11" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.CentralMoment11.class)}
		 */
		public interface CentralMoment11 extends Op {
			String NAME = "imagemoments.centralMoment11";
		}

		/**
		 * Base interface for "centralMoment12" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.CentralMoment12.class)}
		 */
		public interface CentralMoment12 extends Op {
			String NAME = "imagemoments.centralMoment12";
		}

		/**
		 * Base interface for "centralMoment20" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.CentralMoment20.class)}
		 */
		public interface CentralMoment20 extends Op {
			String NAME = "imagemoments.centralMoment20";
		}

		/**
		 * Base interface for "centralMoment21" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.CentralMoment21.class)}
		 */
		public interface CentralMoment21 extends Op {
			String NAME = "imagemoments.centralMoment21";
		}

		/**
		 * Base interface for "centralMoment30" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.CentralMoment30.class)}
		 */
		public interface CentralMoment30 extends Op {
			String NAME = "imagemoments.centralMoment30";
		}

		/**
		 * Base interface for "huMoment1" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.HuMoment1.class)}
		 */
		public interface HuMoment1 extends Op {
			String NAME = "imagemoments.huMoment1";
		}

		/**
		 * Base interface for "huMoment2" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.HuMoment2.class)}
		 */
		public interface HuMoment2 extends Op {
			String NAME = "imagemoments.huMoment2";
		}

		/**
		 * Base interface for "huMoment3" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.HuMoment3.class)}
		 */
		public interface HuMoment3 extends Op {
			String NAME = "imagemoments.huMoment3";
		}

		/**
		 * Base interface for "huMoment4" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.HuMoment4.class)}
		 */
		public interface HuMoment4 extends Op {
			String NAME = "imagemoments.huMoment4";
		}

		/**
		 * Base interface for "huMoment5" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.HuMoment5.class)}
		 */
		public interface HuMoment5 extends Op {
			String NAME = "imagemoments.huMoment5";
		}

		/**
		 * Base interface for "huMoment6" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.HuMoment6.class)}
		 */
		public interface HuMoment6 extends Op {
			String NAME = "imagemoments.huMoment6";
		}

		/**
		 * Base interface for "huMoment7" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.HuMoment7.class)}
		 */
		public interface HuMoment7 extends Op {
			String NAME = "imagemoments.huMoment7";
		}

		/**
		 * Base interface for "moment00" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.Moment00.class)}
		 */
		public interface Moment00 extends Op {
			String NAME = "imagemoments.moment00";
		}

		/**
		 * Base interface for "moment01" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.Moment01.class)}
		 */
		public interface Moment01 extends Op {
			String NAME = "imagemoments.moment01";
		}

		/**
		 * Base interface for "moment10" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.Moment10.class)}
		 */
		public interface Moment10 extends Op {
			String NAME = "imagemoments.moment10";
		}

		/**
		 * Base interface for "moment11" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.Moment11.class)}
		 */
		public interface Moment11 extends Op {
			String NAME = "imagemoments.moment11";
		}

		/**
		 * Base interface for "normalizedCentralMoment02" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.NormalizedCentralMoment02.class)}
		 */
		public interface NormalizedCentralMoment02 extends Op {
			String NAME = "imagemoments.normalizedCentralMoment02";
		}

		/**
		 * Base interface for "normalizedCentralMoment03" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.NormalizedCentralMoment03.class)}
		 */
		public interface NormalizedCentralMoment03 extends Op {
			String NAME = "imagemoments.normalizedCentralMoment03";
		}

		/**
		 * Base interface for "normalizedCentralMoment11" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.NormalizedCentralMoment11.class)}
		 */
		public interface NormalizedCentralMoment11 extends Op {
			String NAME = "imagemoments.normalizedCentralMoment11";
		}

		/**
		 * Base interface for "normalizedCentralMoment12" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.NormalizedCentralMoment12.class)}
		 */
		public interface NormalizedCentralMoment12 extends Op {
			String NAME = "imagemoments.normalizedCentralMoment12";
		}

		/**
		 * Base interface for "normalizedCentralMoment20" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.NormalizedCentralMoment20.class)}
		 */
		public interface NormalizedCentralMoment20 extends Op {
			String NAME = "imagemoments.normalizedCentralMoment20";
		}

		/**
		 * Base interface for "normalizedCentralMoment21" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.NormalizedCentralMoment21.class)}
		 */
		public interface NormalizedCentralMoment21 extends Op {
			String NAME = "imagemoments.normalizedCentralMoment21";
		}

		/**
		 * Base interface for "normalizedCentralMoment30" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.ImageMoments.NormalizedCentralMoment30.class)}
		 */
		public interface NormalizedCentralMoment30 extends Op {
			String NAME = "imagemoments.normalizedCentralMoment30";
		}
	}

	/** Built-in op interfaces of the labeling namespace. */
	public static final class Labeling {

		private Labeling() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "cca" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Labeling.CCA.class)}
		 */
		public interface CCA extends Op {
			String NAME = "labeling.cca";
			String ALIASES = "labeling.connectedComponents, labeling.connectedComponentAnalysis";
		}

		/**
		 * Base interface for "merge" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Labeling.Merge.class)}
		 */
		public interface Merge extends Op {
			String NAME = "labeling.merge";
		}
	}

	/** Built-in op interfaces of the lbp namespace. */
	public static final class LBP {

		private LBP() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "lbp2D" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.LBP.LBP2D.class)}
		 */
		public interface LBP2D extends Op {
			String NAME = "lbp.lbp2D";
		}
	}

	/** Built-in op interfaces of the linalg namespace. */
	public static final class LinAlg {

		private LinAlg() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "rotate" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.LinAlg.Rotate.class)}
		 */
		public interface Rotate extends Op {
			String NAME = "linalg.rotate";
		}
	}

	/** Built-in op interfaces of the logic namespace. */
	public static final class Logic {

		private Logic() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "and" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Logic.And.class)}
		 */
		public interface And extends Op {
			String NAME = "logic.and";
		}

		/**
		 * Base interface for "bool" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Logic.Bool.class)}
		 */
		public interface Bool extends Op {
			String NAME = "logic.bool";
		}

		/**
		 * Base interface for "conditional" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Logic.Conditional.class)}
		 */
		public interface Conditional extends Op {
			String NAME = "logic.conditional";
		}

		/**
		 * Base interface for "equal" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Logic.Equal.class)}
		 */
		public interface Equal extends Op {
			String NAME = "logic.equal";
		}

		/**
		 * Base interface for "greaterThan" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Logic.GreaterThan.class)}
		 */
		public interface GreaterThan extends Op {
			String NAME = "logic.greaterThan";
			String ALIASES = "logic.gt";
		}

		/**
		 * Base interface for "greaterThanOrEqual" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Logic.GreaterThanOrEqual.class)}
		 */
		public interface GreaterThanOrEqual extends Op {
			String NAME = "logic.greaterThanOrEqual";
			String ALIASES = "logic.gtoe";
		}

		/**
		 * Base interface for "lessThan" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Logic.LessThan.class)}
		 */
		public interface LessThan extends Op {
			String NAME = "logic.lessThan";
			String ALIASES = "logic.lt";
		}

		/**
		 * Base interface for "lessThanOrEqual" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Logic.LessThanOrEqual.class)}
		 */
		public interface LessThanOrEqual extends Op {
			String NAME = "logic.lessThanOrEqual";
			String ALIASES = "logic.ltoe";
		}

		/**
		 * Base interface for "not" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Logic.Not.class)}
		 */
		public interface Not extends Op {
			String NAME = "logic.not";
		}

		/**
		 * Base interface for "notEqual" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Logic.NotEqual.class)}
		 */
		public interface NotEqual extends Op {
			String NAME = "logic.notEqual";
		}

		/**
		 * Base interface for "or" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Logic.Or.class)}
		 */
		public interface Or extends Op {
			String NAME = "logic.or";
		}

		/**
		 * Base interface for "xor" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Logic.Xor.class)}
		 */
		public interface Xor extends Op {
			String NAME = "logic.xor";
		}
	}

	/** Built-in op interfaces of the math namespace. */
	public static final class Math {

		private Math() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "abs" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Abs.class)}
		 */
		public interface Abs extends Op {
			String NAME = "math.abs";
		}

		/**
		 * Base interface for "add" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Add.class)}
		 */
		public interface Add extends Op {
			String NAME = "math.add";
			String ALIASES = "math.sum";
		}

		/**
		 * Base interface for "and" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.And.class)}
		 */
		public interface And extends Op {
			String NAME = "math.and";
		}

		/**
		 * Base interface for "arccos" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Arccos.class)}
		 */
		public interface Arccos extends Op {
			String NAME = "math.arccos";
		}

		/**
		 * Base interface for "arccosh" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Arccosh.class)}
		 */
		public interface Arccosh extends Op {
			String NAME = "math.arccosh";
		}

		/**
		 * Base interface for "arccot" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Arccot.class)}
		 */
		public interface Arccot extends Op {
			String NAME = "math.arccot";
		}

		/**
		 * Base interface for "arccoth" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Arccoth.class)}
		 */
		public interface Arccoth extends Op {
			String NAME = "math.arccoth";
		}

		/**
		 * Base interface for "arccsc" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Arccsc.class)}
		 */
		public interface Arccsc extends Op {
			String NAME = "math.arccsc";
		}

		/**
		 * Base interface for "arccsch" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Arccsch.class)}
		 */
		public interface Arccsch extends Op {
			String NAME = "math.arccsch";
		}

		/**
		 * Base interface for "arcsec" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Arcsec.class)}
		 */
		public interface Arcsec extends Op {
			String NAME = "math.arcsec";
		}

		/**
		 * Base interface for "arcsech" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Arcsech.class)}
		 */
		public interface Arcsech extends Op {
			String NAME = "math.arcsech";
		}

		/**
		 * Base interface for "arcsin" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Arcsin.class)}
		 */
		public interface Arcsin extends Op {
			String NAME = "math.arcsin";
		}

		/**
		 * Base interface for "arcsinh" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Arcsinh.class)}
		 */
		public interface Arcsinh extends Op {
			String NAME = "math.arcsinh";
		}

		/**
		 * Base interface for "arctan" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Arctan.class)}
		 */
		public interface Arctan extends Op {
			String NAME = "math.arctan";
		}

		/**
		 * Base interface for "arctanh" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Arctanh.class)}
		 */
		public interface Arctanh extends Op {
			String NAME = "math.arctanh";
		}

		/**
		 * Base interface for "assign" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Assign.class)}
		 */
		public interface Assign extends Op {
			String NAME = "math.assign";
		}

		/**
		 * Base interface for "ceil" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Ceil.class)}
		 */
		public interface Ceil extends Op {
			String NAME = "math.ceil";
		}

		/**
		 * Base interface for "complement" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Complement.class)}
		 */
		public interface Complement extends Op {
			String NAME = "math.complement";
			String ALIASES = "math.comp, math.not";
		}

		/**
		 * Base interface for "complexConjugateMultiply" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.ComplexConjugateMultiply.class)}
		 */
		public interface ComplexConjugateMultiply extends Op {
			String NAME = "math.complexConjugateMultiply";
		}

		/**
		 * Base interface for "cos" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Cos.class)}
		 */
		public interface Cos extends Op {
			String NAME = "math.cos";
		}

		/**
		 * Base interface for "cosh" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Cosh.class)}
		 */
		public interface Cosh extends Op {
			String NAME = "math.cosh";
		}

		/**
		 * Base interface for "cot" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Cot.class)}
		 */
		public interface Cot extends Op {
			String NAME = "math.cot";
		}

		/**
		 * Base interface for "coth" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Coth.class)}
		 */
		public interface Coth extends Op {
			String NAME = "math.coth";
		}

		/**
		 * Base interface for "csc" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Csc.class)}
		 */
		public interface Csc extends Op {
			String NAME = "math.csc";
		}

		/**
		 * Base interface for "csch" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Csch.class)}
		 */
		public interface Csch extends Op {
			String NAME = "math.csch";
		}

		/**
		 * Base interface for "cubeRoot" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.CubeRoot.class)}
		 */
		public interface CubeRoot extends Op {
			String NAME = "math.cubeRoot";
		}

		/**
		 * Base interface for "divide" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Divide.class)}
		 */
		public interface Divide extends Op {
			String NAME = "math.divide";
			String ALIASES = "math.div, math.quotient";
		}

		/**
		 * Base interface for "exp" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Exp.class)}
		 */
		public interface Exp extends Op {
			String NAME = "math.exp";
		}

		/**
		 * Base interface for "expMinusOne" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.ExpMinusOne.class)}
		 */
		public interface ExpMinusOne extends Op {
			String NAME = "math.expMinusOne";
		}

		/**
		 * Base interface for "floor" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Floor.class)}
		 */
		public interface Floor extends Op {
			String NAME = "math.floor";
		}

		/**
		 * Base interface for "gamma" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Gamma.class)}
		 */
		public interface Gamma extends Op {
			String NAME = "math.gamma";
		}

		/**
		 * Base interface for "invert" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Invert.class)}
		 */
		public interface Invert extends Op {
			String NAME = "math.invert";
		}

		/**
		 * Base interface for "leftShift" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.LeftShift.class)}
		 */
		public interface LeftShift extends Op {
			String NAME = "math.leftShift";
			String ALIASES = "math.lshift";
		}

		/**
		 * Base interface for "log" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Log.class)}
		 */
		public interface Log extends Op {
			String NAME = "math.log";
		}

		/**
		 * Base interface for "log10" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Log10.class)}
		 */
		public interface Log10 extends Op {
			String NAME = "math.log10";
		}

		/**
		 * Base interface for "log2" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Log2.class)}
		 */
		public interface Log2 extends Op {
			String NAME = "math.log2";
		}

		/**
		 * Base interface for "logOnePlusX" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.LogOnePlusX.class)}
		 */
		public interface LogOnePlusX extends Op {
			String NAME = "math.logOnePlusX";
		}

		/**
		 * Base interface for "max" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Max.class)}
		 */
		public interface Max extends Op {
			String NAME = "math.max";
		}

		/**
		 * Base interface for "min" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Min.class)}
		 */
		public interface Min extends Op {
			String NAME = "math.min";
		}

		/**
		 * Base interface for "multiply" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Multiply.class)}
		 */
		public interface Multiply extends Op {
			String NAME = "math.multiply";
			String ALIASES = "math.mul, math.product";
		}

		/**
		 * Base interface for "nearestInt" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.NearestInt.class)}
		 */
		public interface NearestInt extends Op {
			String NAME = "math.nearestInt";
		}

		/**
		 * Base interface for "negate" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Negate.class)}
		 */
		public interface Negate extends Op {
			String NAME = "math.negate";
		}

		/**
		 * Base interface for "or" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Or.class)}
		 */
		public interface Or extends Op {
			String NAME = "math.or";
		}

		/**
		 * Base interface for "power" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Power.class)}
		 */
		public interface Power extends Op {
			String NAME = "math.power";
			String ALIASES = "math.pow";
		}

		/**
		 * Base interface for "randomGaussian" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.RandomGaussian.class)}
		 */
		public interface RandomGaussian extends Op {
			String NAME = "math.randomGaussian";
		}

		/**
		 * Base interface for "randomUniform" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.RandomUniform.class)}
		 */
		public interface RandomUniform extends Op {
			String NAME = "math.randomUniform";
		}

		/**
		 * Base interface for "reciprocal" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Reciprocal.class)}
		 */
		public interface Reciprocal extends Op {
			String NAME = "math.reciprocal";
		}

		/**
		 * Base interface for "remainder" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Remainder.class)}
		 */
		public interface Remainder extends Op {
			String NAME = "math.remainder";
			String ALIASES = "math.modulus, math.mod";
		}

		/**
		 * Base interface for "rightShift" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.RightShift.class)}
		 */
		public interface RightShift extends Op {
			String NAME = "math.rightShift";
			String ALIASES = "math.rshift";
		}

		/**
		 * Base interface for "round" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Round.class)}
		 */
		public interface Round extends Op {
			String NAME = "math.round";
		}

		/**
		 * Base interface for "sec" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Sec.class)}
		 */
		public interface Sec extends Op {
			String NAME = "math.sec";
		}

		/**
		 * Base interface for "sech" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Sech.class)}
		 */
		public interface Sech extends Op {
			String NAME = "math.sech";
		}

		/**
		 * Base interface for "signum" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Signum.class)}
		 */
		public interface Signum extends Op {
			String NAME = "math.signum";
		}

		/**
		 * Base interface for "sin" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Sin.class)}
		 */
		public interface Sin extends Op {
			String NAME = "math.sin";
		}

		/**
		 * Base interface for "sinc" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Sinc.class)}
		 */
		public interface Sinc extends Op {
			String NAME = "math.sinc";
		}

		/**
		 * Base interface for "sincPi" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.SincPi.class)}
		 */
		public interface SincPi extends Op {
			String NAME = "math.sincPi";
		}

		/**
		 * Base interface for "sinh" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Sinh.class)}
		 */
		public interface Sinh extends Op {
			String NAME = "math.sinh";
		}

		/**
		 * Base interface for "sqr" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Sqr.class)}
		 */
		public interface Sqr extends Op {
			String NAME = "math.sqr";
		}

		/**
		 * Base interface for "sqrt" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Sqrt.class)}
		 */
		public interface Sqrt extends Op {
			String NAME = "math.sqrt";
		}

		/**
		 * Base interface for "step" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Step.class)}
		 */
		public interface Step extends Op {
			String NAME = "math.step";
		}

		/**
		 * Base interface for "subtract" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Subtract.class)}
		 */
		public interface Subtract extends Op {
			String NAME = "math.subtract";
			String ALIASES = "math.sub, math.diff, math.difference";
		}

		/**
		 * Base interface for "tan" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Tan.class)}
		 */
		public interface Tan extends Op {
			String NAME = "math.tan";
		}

		/**
		 * Base interface for "tanh" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Tanh.class)}
		 */
		public interface Tanh extends Op {
			String NAME = "math.tanh";
		}

		/**
		 * Base interface for "ulp" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Ulp.class)}
		 */
		public interface Ulp extends Op {
			String NAME = "math.ulp";
		}

		/**
		 * Base interface for "unsignedRightShift" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.UnsignedRightShift.class)}
		 */
		public interface UnsignedRightShift extends Op {
			String NAME = "math.unsignedRightShift";
			String ALIASES = "math.urshift";
		}

		/**
		 * Base interface for "xor" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Xor.class)}
		 */
		public interface Xor extends Op {
			String NAME = "math.xor";
		}

		/**
		 * Base interface for "zero" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Math.Zero.class)}
		 */
		public interface Zero extends Op {
			String NAME = "math.zero";
		}
	}

	/** Built-in op interfaces of the morphology namespace. */
	public static final class Morphology {

		private Morphology() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "blackTopHat" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.BlackTopHat.class)}
		 */
		public interface BlackTopHat extends Op {
			String NAME = "morphology.blackTopHat";
		}

		/**
		 * Base interface for "close" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.Close.class)}
		 */
		public interface Close extends Op {
			String NAME = "morphology.close";
		}

		/**
		 * Base interface for "dilate" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.Dilate.class)}
		 */
		public interface Dilate extends Op {
			String NAME = "morphology.dilate";
		}

		/**
		 * Base interface for "erode" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.Erode.class)}
		 */
		public interface Erode extends Op {
			String NAME = "morphology.erode";
		}

		/**
		 * Base interface for "extractHoles" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.ExtractHoles.class)}
		 */
		public interface ExtractHoles extends Op {
			String NAME = "morphology.extractHoles";
		}

		/**
		 * Base interface for "fillHoles" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.FillHoles.class)}
		 */
		public interface FillHoles extends Op {
			String NAME = "morphology.fillHoles";
		}

		/**
		 * Base interface for "floodFill" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.FloodFill.class)}
		 */
		public interface FloodFill extends Op {
			String NAME = "morphology.floodFill";
		}

		/**
		 * Base interface for "open" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.Open.class)}
		 */
		public interface Open extends Op {
			String NAME = "morphology.open";
		}

		/**
		 * Base interface for "outline" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.Outline.class)}
		 */
		public interface Outline extends Op {
			String NAME = "morphology.outline";
		}

		/**
		 * Base interface for "thinGuoHall" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.ThinGuoHall.class)}
		 */
		public interface ThinGuoHall extends Op {
			String NAME = "morphology.thinGuoHall";
		}

		/**
		 * Base interface for "thinHilditch" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.ThinHilditch.class)}
		 */
		public interface ThinHilditch extends Op {
			String NAME = "morphology.thinHilditch";
		}

		/**
		 * Base interface for "thinMorphological" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.ThinMorphological.class)}
		 */
		public interface ThinMorphological extends Op {
			String NAME = "morphology.thinMorphological";
		}

		/**
		 * Base interface for "thinZhangSuen" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.ThinZhangSuen.class)}
		 */
		public interface ThinZhangSuen extends Op {
			String NAME = "morphology.thinZhangSuen";
		}

		/**
		 * Base interface for "topHat" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Morphology.TopHat.class)}
		 */
		public interface TopHat extends Op {
			String NAME = "morphology.topHat";
		}
	}

	/** Built-in op interfaces of the segment namespace. */
	public static final class Segment {

		private Segment() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "detectRidges" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Segment.DetectRidges.class)}
		 */
		public interface DetectRidges extends Op {
			String NAME = "segment.detectRidges";
		}

		/**
		 * Base interface for "detectJunctions" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Segment.DetectJunctions.class)}
		 */
		public interface DetectJunctions extends Op {
			String NAME = "segment.detectJunctions";
		}
	}

	/** Built-in op interfaces of the stats namespace. */
	public static final class Stats {

		private Stats() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "geometricMean" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.GeometricMean.class)}
		 */
		public interface GeometricMean extends Op {
			String NAME = "stats.geometricMean";
		}

		/**
		 * Base interface for "harmonicMean" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.HarmonicMean.class)}
		 */
		public interface HarmonicMean extends Op {
			String NAME = "stats.harmonicMean";
		}

		/**
		 * Base interface for "integralMean" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.IntegralMean.class)}
		 */
		public interface IntegralMean extends Op {
			String NAME = "stats.integralMean";
		}

		/**
		 * Base interface for "integralSum" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.IntegralSum.class)}
		 */
		public interface IntegralSum extends Op {
			String NAME = "stats.integralSum";
		}

		/**
		 * Base interface for "integralVariance" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.IntegralVariance.class)}
		 */
		public interface IntegralVariance extends Op {
			String NAME = "stats.integralVariance";
		}

		/**
		 * Base interface for "kurtosis" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Kurtosis.class)}
		 */
		public interface Kurtosis extends Op {
			String NAME = "stats.kurtosis";
		}

		/**
		 * Base interface for "leastSquares" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.LeastSquares.class)}
		 */
		public interface LeastSquares extends Op {
			String NAME = "stats.leastSquares";
		}

		/**
		 * Base interface for "max" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Max.class)}
		 */
		public interface Max extends Op {
			String NAME = "stats.max";
		}

		/**
		 * Base interface for "mean" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Mean.class)}
		 */
		public interface Mean extends Op {
			String NAME = "stats.mean";
			String ALIASES = "stats.avg";
		}

		/**
		 * Base interface for "median" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Median.class)}
		 */
		public interface Median extends Op {
			String NAME = "stats.median";
		}

		/**
		 * Base interface for "min" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Min.class)}
		 */
		public interface Min extends Op {
			String NAME = "stats.min";
		}

		/**
		 * Base interface for "minMax" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.MinMax.class)}
		 */
		public interface MinMax extends Op {
			String NAME = "stats.minMax";
		}

		/**
		 * Base interface for "moment1AboutMean" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Moment1AboutMean.class)}
		 */
		public interface Moment1AboutMean extends Op {
			String NAME = "stats.moment1AboutMean";
		}

		/**
		 * Base interface for "moment2AboutMean" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Moment2AboutMean.class)}
		 */
		public interface Moment2AboutMean extends Op {
			String NAME = "stats.moment2AboutMean";
		}

		/**
		 * Base interface for "moment3AboutMean" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Moment3AboutMean.class)}
		 */
		public interface Moment3AboutMean extends Op {
			String NAME = "stats.moment3AboutMean";
		}

		/**
		 * Base interface for "moment4AboutMean" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Moment4AboutMean.class)}
		 */
		public interface Moment4AboutMean extends Op {
			String NAME = "stats.moment4AboutMean";
		}

		/**
		 * Base interface for "percentile" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Percentile.class)}
		 */
		public interface Percentile extends Op {
			String NAME = "stats.percentile";
		}

		/**
		 * Base interface for "quantile" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Quantile.class)}
		 */
		public interface Quantile extends Op {
			String NAME = "stats.quantile";
		}

		/**
		 * Base interface for "size" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Size.class)}
		 */
		public interface Size extends Op {
			String NAME = "stats.size";
		}

		/**
		 * Base interface for "skewness" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Skewness.class)}
		 */
		public interface Skewness extends Op {
			String NAME = "stats.skewness";
		}

		/**
		 * Base interface for "stdDev" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.StdDev.class)}
		 */
		public interface StdDev extends Op {
			String NAME = "stats.stdDev";
		}

		/**
		 * Base interface for "sum" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Sum.class)}
		 */
		public interface Sum extends Op {
			String NAME = "stats.sum";
		}

		/**
		 * Base interface for "sumOfInverses" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.SumOfInverses.class)}
		 */
		public interface SumOfInverses extends Op {
			String NAME = "stats.sumOfInverses";
		}

		/**
		 * Base interface for "sumOfLogs" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.SumOfLogs.class)}
		 */
		public interface SumOfLogs extends Op {
			String NAME = "stats.sumOfLogs";
		}

		/**
		 * Base interface for "sumOfSquares" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.SumOfSquares.class)}
		 */
		public interface SumOfSquares extends Op {
			String NAME = "stats.sumOfSquares";
		}

		/**
		 * Base interface for "variance" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Stats.Variance.class)}
		 */
		public interface Variance extends Op {
			String NAME = "stats.variance";
		}
	}

	/** Built-in op interfaces of the tamura namespace. */
	public static final class Tamura {

		private Tamura() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "coarseness" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Tamura.Coarseness.class)}
		 */
		public interface Coarseness extends Op {
			String NAME = "tamura.coarseness";
		}

		/**
		 * Base interface for "contrast" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Tamura.Contrast.class)}
		 */
		public interface Contrast extends Op {
			String NAME = "tamura.contrast";
		}

		/**
		 * Base interface for "directionality" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Tamura.Directionality.class)}
		 */
		public interface Directionality extends Op {
			String NAME = "tamura.directionality";
		}
	}

	/** Built-in op interfaces of the thread namespace. */
	public static final class Thread {

		private Thread() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "chunker" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Thread.Chunker.class)}
		 */
		public interface Chunker extends Op {
			String NAME = "thread.chunker";
		}
	}

	/** Built-in op interfaces of the threshold namespace. */
	public static final class Threshold {

		private Threshold() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "apply" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Apply.class)}
		 */
		public interface Apply extends Op {
			String NAME = "threshold.apply";
		}

		/**
		 * Base interface for "huang" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Huang.class)}
		 */
		public interface Huang extends Op {
			String NAME = "threshold.huang";
		}

		/**
		 * Base interface for "ij1" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.IJ1.class)}
		 */
		public interface IJ1 extends Op {
			String NAME = "threshold.ij1";
		}

		/**
		 * Base interface for "intermodes" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Intermodes.class)}
		 */
		public interface Intermodes extends Op {
			String NAME = "threshold.intermodes";
		}

		/**
		 * Base interface for "isoData" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.IsoData.class)}
		 */
		public interface IsoData extends Op {
			String NAME = "threshold.isoData";
		}

		/**
		 * Base interface for "li" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Li.class)}
		 */
		public interface Li extends Op {
			String NAME = "threshold.li";
		}

		/**
		 * Base interface for "localBernsenThreshold" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.LocalBernsenThreshold.class)}
		 */
		public interface LocalBernsenThreshold extends Op {
			String NAME = "threshold.localBernsenThreshold";
		}

		/**
		 * Base interface for "localContrastThreshold" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.LocalContrastThreshold.class)}
		 */
		public interface LocalContrastThreshold extends Op {
			String NAME = "threshold.localContrastThreshold";
		}

		/**
		 * Base interface for "localMeanThreshold" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.LocalMeanThreshold.class)}
		 */
		public interface LocalMeanThreshold extends Op {
			String NAME = "threshold.localMeanThreshold";
		}

		/**
		 * Base interface for "localMedianThreshold" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.LocalMedianThreshold.class)}
		 */
		public interface LocalMedianThreshold extends Op {
			String NAME = "threshold.localMedianThreshold";
		}

		/**
		 * Base interface for "localMidGreyThreshold" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.LocalMidGreyThreshold.class)}
		 */
		public interface LocalMidGreyThreshold extends Op {
			String NAME = "threshold.localMidGreyThreshold";
		}

		/**
		 * Base interface for "localNiblackThreshold" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.LocalNiblackThreshold.class)}
		 */
		public interface LocalNiblackThreshold extends Op {
			String NAME = "threshold.localNiblackThreshold";
		}

		/**
		 * Base interface for "localPhansalkarThreshold" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.LocalPhansalkarThreshold.class)}
		 */
		public interface LocalPhansalkarThreshold extends Op {
			String NAME = "threshold.localPhansalkarThreshold";
		}

		/**
		 * Base interface for "localSauvolaThreshold" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.LocalSauvolaThreshold.class)}
		 */
		public interface LocalSauvolaThreshold extends Op {
			String NAME = "threshold.localSauvolaThreshold";
		}

		/**
		 * Base interface for "maxEntropy" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.MaxEntropy.class)}
		 */
		public interface MaxEntropy extends Op {
			String NAME = "threshold.maxEntropy";
		}

		/**
		 * Base interface for "maxLikelihood" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.MaxLikelihood.class)}
		 */
		public interface MaxLikelihood extends Op {
			String NAME = "threshold.maxLikelihood";
		}

		/**
		 * Base interface for "mean" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Mean.class)}
		 */
		public interface Mean extends Op {
			String NAME = "threshold.mean";
		}

		/**
		 * Base interface for "minError" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.MinError.class)}
		 */
		public interface MinError extends Op {
			String NAME = "threshold.minError";
		}

		/**
		 * Base interface for "minimum" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Minimum.class)}
		 */
		public interface Minimum extends Op {
			String NAME = "threshold.minimum";
		}

		/**
		 * Base interface for "moments" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Moments.class)}
		 */
		public interface Moments extends Op {
			String NAME = "threshold.moments";
		}

		/**
		 * Base interface for "otsu" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Otsu.class)}
		 */
		public interface Otsu extends Op {
			String NAME = "threshold.otsu";
		}

		/**
		 * Base interface for "percentile" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Percentile.class)}
		 */
		public interface Percentile extends Op {
			String NAME = "threshold.percentile";
		}

		/**
		 * Base interface for "renyiEntropy" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.RenyiEntropy.class)}
		 */
		public interface RenyiEntropy extends Op {
			String NAME = "threshold.renyiEntropy";
		}

		/**
		 * Base interface for "shanbhag" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Shanbhag.class)}
		 */
		public interface Shanbhag extends Op {
			String NAME = "threshold.shanbhag";
		}

		/**
		 * Base interface for "triangle" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Triangle.class)}
		 */
		public interface Triangle extends Op {
			String NAME = "threshold.triangle";
		}

		/**
		 * Base interface for "yen" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Yen.class)}
		 */
		public interface Yen extends Op {
			String NAME = "threshold.yen";
		}

		/**
		 * Base interface for "rosin" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Threshold.Rosin.class)}
		 */
		public interface Rosin extends Op {
			String NAME = "threshold.rosin";
		}
	}

	/** Built-in op interfaces of the topology namespace. */
	public static final class Topology {

		private Topology() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "boxCount" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Topology.BoxCount.class)}
		 */
		public interface BoxCount extends Op {
			String NAME = "topology.boxCount";
		}

		/**
		 * Base interface for "eulerCharacteristic26N" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Topology.EulerCharacteristic26N.class)}
		 */
		public interface EulerCharacteristic26N extends Op {
			String NAME = "topology.eulerCharacteristic26N";
		}

		/**
		 * Base interface for "eulerCharacteristic26NFloating" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Topology.EulerCharacteristic26NFloating.class)}
		 */
		public interface EulerCharacteristic26NFloating extends Op {
			String NAME = "topology.eulerCharacteristic26NFloating";
		}

		/**
		 * Base interface for "eulerCorrection" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Topology.EulerCorrection.class)}
		 */
		public interface EulerCorrection extends Op {
			String NAME = "topology.eulerCorrection";
		}
	}

	/** Built-in op interfaces of the transform namespace. */
	public static final class Transform {

		private Transform() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "addDimensionView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.AddDimensionView.class)}
		 */
		public interface AddDimensionView extends Op {
			String NAME = "transform.addDimensionView";
		}

		/**
		 * Base interface for "collapseNumericView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.CollapseNumericView.class)}
		 */
		public interface CollapseNumericView extends Op {
			String NAME = "transform.collapseNumericView";
		}

		/**
		 * Base interface for "collapseRealView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.CollapseRealView.class)}
		 */
		public interface CollapseRealView extends Op {
			String NAME = "transform.collapseRealView";
		}

		/**
		 * Base interface for "collapseView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.CollapseView.class)}
		 */
		public interface CollapseView extends Op {
			String NAME = "transform.collapseView";
		}

		/**
		 * Base interface for "crop" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.Crop.class)}
		 */
		public interface Crop extends Op {
			String NAME = "transform.crop";
			String ALIASES = "transform.slice";
		}

		/**
		 * Base interface for "dropSingletonDimensionsView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.DropSingletonDimensionsView.class)}
		 */
		public interface DropSingletonDimensionsView extends Op {
			String NAME = "transform.dropSingletonDimensionsView";
		}

		/**
		 * Base interface for "extendBorderView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.ExtendBorderView.class)}
		 */
		public interface ExtendBorderView extends Op {
			String NAME = "transform.extendBorderView";
		}

		/**
		 * Base interface for "extendMirrorDoubleView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.ExtendMirrorDoubleView.class)}
		 */
		public interface ExtendMirrorDoubleView extends Op {
			String NAME = "transform.extendMirrorDoubleView";
		}

		/**
		 * Base interface for "extendMirrorSingleView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.ExtendMirrorSingleView.class)}
		 */
		public interface ExtendMirrorSingleView extends Op {
			String NAME = "transform.extendMirrorSingleView";
		}

		/**
		 * Base interface for "extendPeriodicView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.ExtendPeriodicView.class)}
		 */
		public interface ExtendPeriodicView extends Op {
			String NAME = "transform.extendPeriodicView";
		}

		/**
		 * Base interface for "extendRandomView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.ExtendRandomView.class)}
		 */
		public interface ExtendRandomView extends Op {
			String NAME = "transform.extendRandomView";
		}

		/**
		 * Base interface for "extendValueView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.ExtendValueView.class)}
		 */
		public interface ExtendValueView extends Op {
			String NAME = "transform.extendValueView";
		}

		/**
		 * Base interface for "extendView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.ExtendView.class)}
		 */
		public interface ExtendView extends Op {
			String NAME = "transform.extendView";
		}

		/**
		 * Base interface for "extendZeroView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.ExtendZeroView.class)}
		 */
		public interface ExtendZeroView extends Op {
			String NAME = "transform.extendZeroView";
		}

		/**
		 * Base interface for "flatIterableView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.FlatIterableView.class)}
		 */
		public interface FlatIterableView extends Op {
			String NAME = "transform.flatIterableView";
		}

		/**
		 * Base interface for "hyperSliceView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.HyperSliceView.class)}
		 */
		public interface HyperSliceView extends Op {
			String NAME = "transform.hyperSliceView";
		}

		/**
		 * Base interface for "interpolateView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.InterpolateView.class)}
		 */
		public interface InterpolateView extends Op {
			String NAME = "transform.interpolateView";
		}

		/**
		 * Base interface for "intervalView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.IntervalView.class)}
		 */
		public interface IntervalView extends Op {
			String NAME = "transform.intervalView";
		}

		/**
		 * Base interface for "invertAxisView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.InvertAxisView.class)}
		 */
		public interface InvertAxisView extends Op {
			String NAME = "transform.invertAxisView";
		}

		/**
		 * Base interface for "iterableView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.IterableView.class)}
		 */
		public interface IterableView extends Op {
			String NAME = "transform.iterableView";
		}

		/**
		 * Base interface for "offsetView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.OffsetView.class)}
		 */
		public interface OffsetView extends Op {
			String NAME = "transform.offsetView";
		}

		/**
		 * Base interface for "permuteCoordinatesInverseView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.PermuteCoordinatesInverseView.class)}
		 */
		public interface PermuteCoordinatesInverseView extends Op {
			String NAME = "transform.permuteCoordinatesInverseView";
		}

		/**
		 * Base interface for "permuteCoordinatesView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.PermuteCoordinatesView.class)}
		 */
		public interface PermuteCoordinatesView extends Op {
			String NAME = "transform.permuteCoordinatesView";
		}

		/**
		 * Base interface for "permuteView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.PermuteView.class)}
		 */
		public interface PermuteView extends Op {
			String NAME = "transform.permuteView";
		}

		/**
		 * Base interface for "project" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.Project.class)}
		 */
		public interface Project extends Op {
			String NAME = "transform.project";
		}

		/**
		 * Base interface for "rasterView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.RasterView.class)}
		 */
		public interface RasterView extends Op {
			String NAME = "transform.rasterView";
		}

		/**
		 * Base interface for "rotateView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.RotateView.class)}
		 */
		public interface RotateView extends Op {
			String NAME = "transform.rotateView";
		}

		/**
		 * Base interface for "scaleView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.ScaleView.class)}
		 */
		public interface ScaleView extends Op {
			String NAME = "transform.scaleView";
			String ALIASES = "transform.resizeView";
		}

		/**
		 * Base interface for "shearView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.ShearView.class)}
		 */
		public interface ShearView extends Op {
			String NAME = "transform.shearView";
		}

		/**
		 * Base interface for "stackView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.StackView.class)}
		 */
		public interface StackView extends Op {
			String NAME = "transform.stackView";
		}

		/**
		 * Base interface for "concatenateView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.ConcatenateView.class)}
		 */
		public interface ConcatenateView extends Op {
			String NAME = "transform.concatenateView";
		}

		/**
		 * Base interface for "subsampleView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.SubsampleView.class)}
		 */
		public interface SubsampleView extends Op {
			String NAME = "transform.subsampleView";
		}

		/**
		 * Base interface for "translateView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.TranslateView.class)}
		 */
		public interface TranslateView extends Op {
			String NAME = "transform.translateView";
		}

		/**
		 * Base interface for "unshearView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.UnshearView.class)}
		 */
		public interface UnshearView extends Op {
			String NAME = "transform.unshearView";
		}

		/**
		 * Base interface for "zeroMinView" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Transform.ZeroMinView.class)}
		 */
		public interface ZeroMinView extends Op {
			String NAME = "transform.zeroMinView";
		}
	}

	/** Built-in op interfaces of the zernike namespace. */
	public static final class Zernike {

		private Zernike() {
			// NB: Prevent instantiation of utility class.
		}

		/**
		 * Base interface for "magnitude" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Zernike.Magnitude.class)}
		 */
		public interface Magnitude extends Op {
			String NAME = "zernike.magnitude";
		}

		/**
		 * Base interface for "phase" operations.
		 * <p>
		 * Implementing classes should be annotated with:
		 * </p>
		 *
		 * {@code @Plugin(type = Ops.Zernike.Phase.class)}
		 */
		public interface Phase extends Op {
			String NAME = "zernike.phase";
		}
	}

}
