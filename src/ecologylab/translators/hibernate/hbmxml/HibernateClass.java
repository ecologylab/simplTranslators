package ecologylab.translators.hibernate.hbmxml;

import ecologylab.generic.HashMapArrayList;
import ecologylab.serialization.ClassDescriptor;
import ecologylab.serialization.annotations.simpl_classes;
import ecologylab.serialization.annotations.simpl_composite;
import ecologylab.serialization.annotations.simpl_inherit;
import ecologylab.serialization.annotations.simpl_map;
import ecologylab.serialization.annotations.simpl_nowrap;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.annotations.simpl_tag;

/**
 * The Hibernate mapping of a class (or entity).
 * 
 * @author quyin
 * 
 */
@simpl_inherit
@simpl_tag("class")
public class HibernateClass extends HibernateBasic
{

	@simpl_scalar
	private String																				name;

	@simpl_scalar
	private String																				table;

	@simpl_composite
	private HibernateClassCache														cache;

	@simpl_composite
	private HibernateClassId															id;

	@simpl_scalar
	@simpl_tag("discriminator-value")
	private String																				discriminatorValue;

	@simpl_composite
	private HibernateClassDiscriminator										discriminator;

	@simpl_map
	@simpl_nowrap
	@simpl_classes({ HibernateProperty.class, HibernateComposite.class, HibernateList.class,
			HibernateMap.class })
	@simpl_serialization_order(8)
	private HashMapArrayList<String, HibernateFieldBase>	properties;
	
	private ClassDescriptor																mappedClassDescriptor;

	public HibernateClass()
	{
		super();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getTable()
	{
		return table;
	}

	public void setTable(String table)
	{
		this.table = table;
	}

	public HibernateClassDiscriminator getDiscriminator()
	{
		return discriminator;
	}

	public void setDiscriminator(HibernateClassDiscriminator discriminator)
	{
		this.discriminator = discriminator;
	}

	public String getDiscriminatorValue()
	{
		return discriminatorValue;
	}

	public void setDiscriminatorValue(String discriminatorValue)
	{
		this.discriminatorValue = discriminatorValue;
	}

	public void setCache(HibernateClassCache cache)
	{
		this.cache = cache;
	}

	public HibernateClassCache getCache()
	{
		return cache;
	}

	public HibernateClassId getId()
	{
		return id;
	}

	public void setId(HibernateClassId id)
	{
		this.id = id;
	}

	public void setProperties(HashMapArrayList<String, HibernateFieldBase> properties)
	{
		this.properties = properties;
	}

	public HashMapArrayList<String, HibernateFieldBase> getProperties()
	{
		return properties;
	}

	public ClassDescriptor getMappedClassDescriptor()
	{
		return mappedClassDescriptor;
	}

	public void setMappedClassDescriptor(ClassDescriptor mappedClassDescriptor)
	{
		this.mappedClassDescriptor = mappedClassDescriptor;
	}

}
