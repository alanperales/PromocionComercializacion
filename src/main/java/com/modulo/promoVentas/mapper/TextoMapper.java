package com.modulo.promoVentas.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.modulo.promoVentas.model.Texto;

@Mapper
public interface TextoMapper {

	@Select("Select * from co_texto")
	public Collection<Texto> listAll();
}
