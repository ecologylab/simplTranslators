package ecologylab.translators.java;

import java.lang.annotation.Annotation;
import java.util.HashMap;

import ecologylab.generic.Debug;
import ecologylab.serialization.FieldDescriptor;
import ecologylab.serialization.simpl_descriptor_classes;
import ecologylab.serialization.ElementState.simpl_classes;
import ecologylab.serialization.ElementState.simpl_collection;
import ecologylab.serialization.ElementState.simpl_hints;
import ecologylab.serialization.ElementState.simpl_map;
import ecologylab.serialization.ElementState.simpl_scope;
import ecologylab.serialization.ElementState.xml_other_tags;
import ecologylab.serialization.ElementState.xml_tag;

public class JavaTranslationUtilities {

	private static HashMap<String, String> keywords = new HashMap<String, String>();
	
	static
	{
		keywords.put("abstract", "abstract");
		keywords.put("continue","continue");
		keywords.put("for","for");
		keywords.put("new","new");
		keywords.put("switch","switch");
		keywords.put("assert","assert");
		keywords.put("default","default");
		keywords.put("package","package");
		keywords.put("synchronized","synchronized");
		keywords.put("boolean","boolean");
		keywords.put("do","do");
		keywords.put("if","if");
		keywords.put("private","private");
		keywords.put("this","this");
		keywords.put("break","break");
		keywords.put("double","double");
		keywords.put("implements","implements");
		keywords.put("protected","protected");
		keywords.put("throw","throw");
		keywords.put("byte","byte");
		keywords.put("else","else");
		keywords.put("import","import");
		keywords.put("public","public");
		keywords.put("throws","throws");
		keywords.put("case","case");
		keywords.put("enum","enum");
		keywords.put("instanceof","instanceof");
		keywords.put("return","return");
		keywords.put("transient","transient");
		keywords.put("catch","catch");
		keywords.put("extends","extends");
		keywords.put("int","int");
		keywords.put("short","short");
		keywords.put("try","try");
		keywords.put("char","char");
		keywords.put("final","final");
		keywords.put("interface","interface");
		keywords.put("static","static");
		keywords.put("void","void");
		keywords.put("class","class");
		keywords.put("finally","finally");
		keywords.put("long","long");
		keywords.put("strictfp","strictfp");
		keywords.put("volatile","volatile");
		keywords.put("const","const");
		keywords.put("float","float");
		keywords.put("native ","native ");
		keywords.put("super","super");
		keywords.put("while","while");
		keywords.put("goto","goto");
	}
	
	/**
	 * Utility method to check if the given field name is a keyword in Java
	 * 
	 * @param fieldName
	 */
	public static boolean isKeyword(String fieldName)
	{
		return keywords.containsKey(fieldName);
	}
	
	/**
	 * Utility function to translate java annotation to java attribute
	 * 
	 * @param annotation
	 * @return
	 */
	/** SSH
	public static String getJavaAnnotation(Annotation annotation)
	{
		String simpleName = getSimpleName(annotation);

		if(annotation instanceof simpl_collection)
		{
			return getJavaCollectionAnnotation(annotation);
		}
		else if (annotation instanceof simpl_map)
		{
			return getJavaMapAnnotation(annotation);
		}		
		else if (annotation instanceof simpl_classes)
		{
			return getJavaClassesAnnotation(annotation);
		}
		else if (annotation instanceof simpl_hints)
		{
			return getJavaHintsAnnotation(annotation);
		}
		else if (annotation instanceof simpl_scope)
		{
			return getJavaScopeAnnotation(annotation);
		}
		else if (annotation instanceof xml_tag)
		{
			return getJavaTagAnnotation(annotation);
		}
		else if (annotation instanceof xml_other_tags)
		{
			return getJavaOtherTagsAnnotation(annotation);
		}
		else if (annotation instanceof simpl_descriptor_classes)
		{
			return getJavaOtherDescAnnotation(annotation);
		}
		else if (annotation instanceof mm_name)
		{
			return getJavaMMNameAnnotation(annotation);
		}

		return simpleName;
	}*/


	private static String getJavaOtherDescAnnotation(Annotation annotation)
	{
		String parameter = null;
		simpl_descriptor_classes classesAnnotation = (simpl_descriptor_classes) annotation;
		Class<?>[] classArray = classesAnnotation.value();

		String simpleName = getSimpleName(annotation);

		if (classArray != null)
		{
			parameter = "(new Type[] { ";

			for (int i = 0; i < classArray.length; i++)
			{
				String tempString = "typeof(" + classArray[i].getSimpleName() + ")";
				if (i != classArray.length - 1)
					parameter += tempString + ", ";
				else
					parameter += tempString;
			}

			parameter += " })";

			return simpleName + parameter;
		}
		else
			return null;
}
	/**
	 * Utility function to translate java classes annotation to Java attribute
	 * 
	 * @param annotation
	 * @return
	 */
	private static String getJavaClassesAnnotation(Annotation annotation)
	{
		String parameter = null;
		simpl_classes classesAnnotation = (simpl_classes) annotation;
		Class<?>[] classArray = classesAnnotation.value();

		String simpleName = getSimpleName(annotation);

		if (classArray != null)
		{
			parameter = "(new Type[] { ";

			for (int i = 0; i < classArray.length; i++)
			{
				String tempString = "typeof(" + classArray[i].getSimpleName() + ")";
				if (i != classArray.length - 1)
					parameter += tempString + ", ";
				else
					parameter += tempString;
			}

			parameter += " })";

			return simpleName + parameter;
		}
		else
			return null;
	}

	/**
	 * Utility function to translate java tag annotation to Java attribute
	 * 
	 * @param annotation
	 * @return
	 */
	public static String getJavaTagAnnotation(String tagValue)
	{
		String parameter = null;
		
		//xml_tag tagAnnotation = (xml_tag) annotation;
		//String tagValue = tagAnnotation.value();

		//String simpleName = getSimpleName(annotation);
		String simpleName = xml_tag.class.getSimpleName();

		if (tagValue != null && !tagValue.isEmpty())
		{
			parameter = "(" + "\"" + tagValue + "\"" + ")";
			return simpleName + parameter;
		}
		else
		{
			return simpleName;
		}
	}
	
	/**
	 * Utility function to translate java hints annotation to Java attribute
	 * 
	 * @param annotation
	 * @return
	 */
	public static String getJavaHintsAnnotation(String tagName)
	{
		String parameter = null;
		
		//String simpleName = getSimpleName(annotation);
		String simpleName = simpl_hints.class.getSimpleName();

		if (tagName != null && !tagName.equals("") )
		{
			parameter = "(new Hint[] { " + tagName;			
			parameter += " })";
			return simpleName + parameter;
		}
		else
		{
			return null;
		}
	}
	

	private static String getJavaScopeAnnotation(Annotation annotation)
	{
		String parameter = null;
		simpl_scope scopeAnnotation = (simpl_scope) annotation;
		String scopeValue = scopeAnnotation.value();
		String simpleName = getSimpleName(scopeAnnotation);
		if(scopeValue != null && !scopeValue.isEmpty())
		{
			parameter = "(\"" + scopeValue + "\")";
			return simpleName + parameter;
		}
		else
		{
			Debug.error(scopeAnnotation, "Scope without a parameter");
			return null;
		}
		
	}
	


	private static String getJavaOtherTagsAnnotation(Annotation annotation)
	{
		String parameter = null;
		xml_other_tags scopeAnnotation = (xml_other_tags) annotation;
		String[] scopeValue = scopeAnnotation.value();
		String simpleName = getSimpleName(scopeAnnotation);
		if(scopeValue != null && scopeValue.length > 0)
		{
			parameter = "(new String[]{";
			for(String otherTag : scopeValue)
				parameter += "\"" + otherTag + "\", ";
			
			parameter += "})";
			return simpleName + parameter;
		}
		else
		{
			Debug.error(scopeAnnotation, "xml_other_tags without any parameters");
			return null;
		}
	}

	/*
	private static String getJavaMMNameAnnotation(Annotation annotation)
	{
		String parameter = null;
		mm_name mmNameAnnotation = (mm_name) annotation;
		String tagValue = mmNameAnnotation.value();
		String simpleName = getSimpleName(annotation);
		if (tagValue != null && !tagValue.isEmpty())
		{
			parameter = "(" + "\"" + tagValue + "\"" + ")";
			return simpleName + parameter;
		}
		else
		{
			return simpleName;
		}
	}*/

	
	/**
	 * Utility function to translate java collection annotation to java attribute
	 * 
	 * @param annotation
	 * @return
	 */
	public static String getJavaCollectionAnnotation(String tagValue)
	{
		String parameter = null;
		//simpl_collection collectionAnnotation = (simpl_collection) annotation;
		//String tagValue = collectionAnnotation.value();
		String simpleName = simpl_collection.class.getSimpleName();

		if (tagValue != null && !tagValue.isEmpty())
		{
			parameter = "(" + "\"" + tagValue + "\"" + ")";
			return simpleName + parameter;
		}
		else
		{
			return simpleName;
		}
	}


	public static String getJavaMapAnnotation(String tagValue)
	{
		String parameter = null;
		String simpleName = simpl_map.class.getSimpleName();

		if (tagValue != null && !tagValue.isEmpty())
		{
			parameter = "(" + "\"" + tagValue + "\"" + ")";
			return simpleName + parameter;
		}
		else
		{
			//SSH check
			Debug.warning(simpl_map.class, "Map declared with no tags");
			return simpleName;
		}
	}

	
	/**
	 * Gets the simple name of the annotation. 
	 * 
	 * @param annotation
	 * @return
	 */
	private static String getSimpleName(Annotation annotation)
	{
		return annotation.annotationType().getSimpleName();
	}
	
	/**
	 * Generatuing the get method name for the given field descriptor
	 * 
	 * @param fieldDescriptor
	 * @return
	 */
	public static String getGetMethodName(FieldDescriptor fieldDescriptor)
	{
		if(fieldDescriptor == null)
		{
			return "null";
		}
		else
		{
			String fieldName = fieldDescriptor.getFieldName();
			StringBuilder propertyName = new StringBuilder();
			
			String declaringClassName = fieldDescriptor.getDeclaringClassDescriptor().getDecribedClassSimpleName();
			
			propertyName.append(JavaTranslationConstants.GET);
			propertyName.append(Character.toUpperCase(fieldName.charAt(0)));
			propertyName.append(fieldName.subSequence(1, fieldName.length()));
						
			return propertyName.toString();
		}			
	}
	
	/**
	 * Generating the set method name for the given field descriptor
	 * 
	 * @param fieldDescriptor
	 * @return
	 */
	public static String getSetMethodName(FieldDescriptor fieldDescriptor)
	{
		if(fieldDescriptor == null)
		{
			return "null";
		}
		else
		{
			String fieldName = fieldDescriptor.getFieldName();
			StringBuilder propertyName = new StringBuilder();
			
			String declaringClassName = fieldDescriptor.getDeclaringClassDescriptor().getDecribedClassSimpleName();
			
			propertyName.append(JavaTranslationConstants.SET);
			propertyName.append(Character.toUpperCase(fieldName.charAt(0)));
			propertyName.append(fieldName.subSequence(1, fieldName.length()));
						
			return propertyName.toString();
		}			
	}
}
