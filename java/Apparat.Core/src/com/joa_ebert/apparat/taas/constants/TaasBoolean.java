/*
 * This file is part of Apparat.
 * 
 * Apparat is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Apparat is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Apparat. If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright (C) 2009 Joa Ebert
 * http://www.joa-ebert.com/
 * 
 */

package com.joa_ebert.apparat.taas.constants;

import com.joa_ebert.apparat.abc.AbcEnvironment;
import com.joa_ebert.apparat.abc.MethodBody;
import com.joa_ebert.apparat.abc.bytecode.Bytecode;
import com.joa_ebert.apparat.abc.bytecode.operations.PushFalse;
import com.joa_ebert.apparat.abc.bytecode.operations.PushTrue;
import com.joa_ebert.apparat.taas.TaasConstant;
import com.joa_ebert.apparat.taas.types.BooleanType;

/**
 * 
 * @author Joa Ebert
 * 
 */
public class TaasBoolean extends TaasConstant
{
	public static final TaasBoolean TRUE = new TaasBoolean( true );
	public static final TaasBoolean FALSE = new TaasBoolean( true );

	public final boolean value;

	private TaasBoolean( final boolean value )
	{
		super( BooleanType.INSTANCE );

		this.value = value;
	}

	@Override
	protected void emitOps( final AbcEnvironment environment,
			final MethodBody body, final Bytecode code )
	{
		code.add( value ? new PushTrue() : new PushFalse() );
	}

	@Override
	public String toString()
	{
		return "[TaasBoolean value: " + Boolean.toString( value ) + "]";
	}
}