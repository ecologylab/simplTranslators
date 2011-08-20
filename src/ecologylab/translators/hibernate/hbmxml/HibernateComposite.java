/**
 * 
 */
package ecologylab.translators.hibernate.hbmxml;

import ecologylab.serialization.ElementState.xml_tag;
import ecologylab.serialization.simpl_inherit;

/**
 * The Hibernate mapping for many-to-one relationships (or composite properties).
 * 
 * @author quyin
 * 
 */
@simpl_inherit
@xml_tag("many-to-one")
public class HibernateComposite extends HibernateProperty
{

	@simpl_scalar
	@xml_tag("class")
	private String	compositeClassName;

	public HibernateComposite()
	{
		super();
		this.setLazy(LAZY_PROXY);
	}

	public void setCompositeClassName(String compositeClassName)
	{
		this.compositeClassName = compositeClassName;
	}

	public String getCompositeClassName()
	{
		return compositeClassName;
	}

}
