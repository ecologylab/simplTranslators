package ecologylab.translators.javascript.test;

import java.io.File;
import java.io.IOException;

import ecologylab.semantics.collecting.MetaMetadataRepositoryInit;
import ecologylab.semantics.metametadata.MetaMetadata;
import ecologylab.semantics.metametadata.MetaMetadataRepository;
import ecologylab.semantics.metametadata.MetaMetadataRepositoryLoader;
import ecologylab.semantics.metametadata.MetaMetadataTranslationScope;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.SimplTypesScope;
import ecologylab.serialization.SimplTypesScope.GRAPH_SWITCH;
import ecologylab.serialization.formatenums.Format;
import ecologylab.serialization.formatenums.StringFormat;
import ecologylab.translators.javascript.JavascriptTranslator;

public class MMDToJS
{
	public static void main(String[] args) throws IOException, SIMPLTranslationException
	{
		//MMD In JSON, that needs to be deserialized by simpl.js.
		//{"meta_metadata":{"name":"acm_portal","package":"ecologylab.semantics.generated.library.scholarlyPublication","schema_org_itemtype":"http://schema.org/ScholarlyArticle","type":"scholarly_article","user_agent_name":"google_bot_2","user_agent_string":"Googlebot/2.1 (+http://www.googlebot.com/bot.html)","parser":"xpath","redirect_handling":"REDIRECT_USUAL","visibility":"GLOBAL","kids":[{"scalar":{"name":"title","xpath":"//div[@class='large-text']/h1","style":"metadata_h1","layer":"10","navigates_to":"metadata_page","as_natural_id":"title","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"name":"abstract_field","tag":"abstract","xpath":"//h1/a[contains(text(), 'ABSTRACT')]/ancestor::h1/following-sibling::div[@class='flatbody'][1]","layer":"9","label":"abstract","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.id":"55110660","name":"description","layer":"9","schema_org_itemprop":"description","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"collection":{"name":"authors","xpath":"//div[@id='divmain']//a[@title='Author Profile Page']","layer":"8","schema_org_itemprop":"author","package":"ecologylab.semantics.generated.library.creativeWork","child_type":"author","kids":[{"composite":{"name":"author","package":"ecologylab.semantics.generated.library.creativeWork","type":"author","kids":[{"scalar":{"name":"title","xpath":"./text()","style":"metadata_h1","layer":"10","navigates_to":"location","label":"name","is_facet":"True","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"name":"location","xpath":"./@href","hide":"True","always_show":"True","layer":"8","schema_org_itemprop":"url","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute","filter":{"regex":"(&coll=DL)|(&dl=ACM)|(&trk=\\d+)|(&cfid=\\d+)|(&cftoken=\\d+)|(&CFID=\\d+)|(&CFTOKEN=\\d+)","replace":""}}},{"scalar":{"simpl.id":"39333393","name":"meta_metadata_name","comment":"Stores the name of the meta-metadata, and is used on restoring from XML.","tag":"mm_name","hide":"True","ignore_in_term_vector":"True","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.id":"2056392","name":"city","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"collection":{"simpl.id":"17203224","name":"mixins","package":"ecologylab.semantics.generated.library","promote_children":"True","polymorphic_scope":"repository_metadata","child_type":"metadata","kids":[{"composite":{"name":"metadata","package":"ecologylab.semantics.generated.library","promote_children":"True","type":"metadata","kids":[{"collection":{"simpl.ref":"17203224"}},{"scalar":{"simpl.ref":"39333393"}}]}}]}},{"scalar":{"name":"affiliation","xpath":"../..//a[@title='Institutional Profile Page']","schema_org_itemprop":"affiliation","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"collection":{"simpl.id":"51103196","name":"additional_locations","hide":"True","package":"ecologylab.semantics.generated.library","child_tag":"location","child_scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","kids":[]}}]}}]}},{"scalar":{"simpl.id":"5127738","name":"location","hide":"True","always_show":"True","layer":"8","schema_org_itemprop":"url","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute"}},{"composite":{"name":"source","xpath":"//h1/a/span[contains(text(), 'PUBLICATION')]/ancestor::h1/following-sibling::div[@class='flatbody'][1]","layer":"7","navigates_to":"location","package":"ecologylab.semantics.generated.library.scholarlyPublication","type":"periodical","kids":[{"scalar":{"name":"title","xpath":".//td[text()='Title']/following-sibling::td[1]","style":"metadata_h1","layer":"10","navigates_to":"location","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"simpl.id":"13594899","name":"abstract_field","tag":"abstract","layer":"9","label":"abstract","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"name":"location","xpath":".//td[text()='Title']/following-sibling::td/a[1]","hide":"True","always_show":"True","layer":"8","schema_org_itemprop":"url","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute"}},{"collection":{"name":"authors","comment":"Publication general/program chairs.","xpath":".//td[contains(text(), 'Chairs')]/following-sibling::td/a","layer":"8","label":"chairs","schema_org_itemprop":"author","package":"ecologylab.semantics.generated.library.creativeWork","child_type":"author","kids":[{"composite":{"name":"author","package":"ecologylab.semantics.generated.library.creativeWork","type":"author","kids":[{"scalar":{"name":"title","xpath":".","style":"metadata_h1","layer":"10","navigates_to":"location","label":"name","is_facet":"True","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"name":"location","xpath":"./@href","hide":"True","always_show":"True","layer":"8","schema_org_itemprop":"url","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute","filter":{"regex":"(&coll=DL)|(&dl=ACM)|(&trk=\\d+)|(&cfid=\\d+)|(&cftoken=\\d+)|(&CFID=\\d+)|(&CFTOKEN=\\d+)","replace":""}}},{"scalar":{"simpl.id":"46266773","name":"affiliation","schema_org_itemprop":"affiliation","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"2056392"}},{"scalar":{"simpl.ref":"39333393"}},{"collection":{"simpl.ref":"51103196"}},{"collection":{"simpl.ref":"17203224"}}]}}]}},{"scalar":{"simpl.id":"17889527","name":"page_structure","comment":"For debugging. Type of the structure recognized by information extraction.","hide":"True","layer":"6","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.id":"62381978","name":"query","comment":"The search query","layer":"5","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.id":"7524288","name":"date","comment":"Publication Date","schema_org_itemprop":"datePublished","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataDateScalarType","hint":"XmlAttribute"}},{"composite":{"simpl.id":"40060369","name":"publisher","schema_org_itemprop":"publisher","package":"ecologylab.semantics.generated.library.creativeWork","type":"publisher","kids":[{"scalar":{"name":"title","style":"metadata_h1","layer":"10","navigates_to":"location","label":"name","is_facet":"True","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"simpl.id":"31291299","name":"location","comment":"The document's actual location.","hide":"True","always_show":"True","layer":"8","schema_org_itemprop":"url","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute"}},{"scalar":{"name":"city","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"39333393"}},{"collection":{"simpl.ref":"17203224"}},{"collection":{"simpl.ref":"51103196"}}]}},{"scalar":{"simpl.id":"54434552","name":"volume_and_issue","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"collection":{"simpl.ref":"51103196"}},{"composite":{"simpl.id":"17224130","name":"archive","comment":"All the issues of a periodical.","package":"ecologylab.semantics.generated.library.creativeWork","type":"document","kids":[{"scalar":{"simpl.id":"35100727","name":"title","comment":"The Title of the Document","style":"metadata_h1","layer":"10","navigates_to":"location","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"name":"location","hide":"True","always_show":"True","layer":"8","schema_org_itemprop":"url","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute"}},{"collection":{"simpl.ref":"51103196"}},{"collection":{"simpl.ref":"17203224"}},{"scalar":{"simpl.ref":"39333393"}}]}},{"scalar":{"name":"year","xpath":".//td[text()='Publisher']/following-sibling::td","label":"year published","is_facet":"True","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataIntegerScalarType","hint":"XmlAttribute","filter":{"regex":"[\\D]","replace":""}}},{"scalar":{"name":"isbn","xpath":".//td[text()='Publisher']/parent::*/following-sibling::tr/td[2]","schema_org_itemprop":"author","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute","filter":{"regex":"\\d\\d\\d-\\d-\\d\\d\\d\\d\\d-\\d\\d\\d-\\d"}}},{"collection":{"simpl.ref":"17203224"}},{"collection":{"simpl.id":"3419394","name":"clippings","comment":"Clippings that this document contains.","hide":"True","package":"ecologylab.semantics.generated.library","polymorphic_scope":"repository_clippings","child_type":"clipping","kids":[{"composite":{"name":"clipping","package":"ecologylab.semantics.generated.library","type":"clipping","kids":[{"scalar":{"name":"context","layer":"10","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"name":"context_html","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"name":"xpath","hide":"True","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"composite":{"name":"source_doc","label":"source","package":"ecologylab.semantics.generated.library","polymorphic_scope":"repository_documents","type":"document","kids":[{"scalar":{"simpl.ref":"35100727"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"simpl.ref":"31291299"}},{"collection":{"simpl.ref":"51103196"}},{"collection":{"simpl.ref":"17203224"}},{"scalar":{"simpl.ref":"39333393"}}]}},{"composite":{"name":"outlink","package":"ecologylab.semantics.generated.library","polymorphic_scope":"repository_documents","type":"document","kids":[{"scalar":{"simpl.ref":"35100727"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"simpl.ref":"31291299"}},{"collection":{"simpl.ref":"51103196"}},{"collection":{"simpl.ref":"17203224"}},{"scalar":{"simpl.ref":"39333393"}}]}},{"collection":{"simpl.ref":"17203224"}},{"scalar":{"simpl.ref":"39333393"}}]}}]}},{"scalar":{"simpl.ref":"39333393"}}]}},{"scalar":{"simpl.ref":"17889527"}},{"scalar":{"simpl.ref":"62381978"}},{"scalar":{"simpl.id":"17194169","name":"year","is_facet":"True","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataIntegerScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.id":"33872309","name":"metadata_page","comment":"citation.cfm","shadows":"location","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"39333393"}},{"collection":{"simpl.ref":"51103196"}},{"collection":{"simpl.ref":"17203224"}},{"collection":{"name":"citations","xpath":"//h1/a/span[contains(text(), 'CITED BY')]/ancestor::h1/following-sibling::div[@class='flatbody'][1]//tr/td[2]","package":"ecologylab.semantics.generated.library.scholarlyPublication","child_tag":"citation","child_type":"scholarly_article","kids":[{"composite":{"name":"scholarly_article","tag":"citation","package":"ecologylab.semantics.generated.library.scholarlyPublication","type":"scholarly_article","kids":[{"scalar":{"name":"title","style":"metadata_h1","layer":"20","navigates_to":"location","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"simpl.ref":"13594899"}},{"collection":{"name":"authors","layer":"8","schema_org_itemprop":"author","package":"ecologylab.semantics.generated.library.creativeWork","child_type":"author","kids":[{"composite":{"name":"author","package":"ecologylab.semantics.generated.library.creativeWork","type":"author","kids":[{"scalar":{"name":"title","style":"metadata_h1","layer":"10","navigates_to":"location","label":"name","is_facet":"True","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"simpl.id":"29100051","name":"location","hide":"True","always_show":"True","layer":"8","schema_org_itemprop":"url","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"46266773"}},{"scalar":{"simpl.ref":"2056392"}},{"scalar":{"simpl.ref":"39333393"}},{"collection":{"simpl.ref":"51103196"}},{"collection":{"simpl.ref":"17203224"}}]}}],"field_parser":{"name":"regex_split","regex":"\\s,\\s","trim":"True"}}},{"scalar":{"name":"location","xpath":".//a[1]/@href","hide":"True","always_show":"True","layer":"8","schema_org_itemprop":"url","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute","filter":{"regex":"(cfid=\\d+&cftoken=\\d+)|(CFID=\\d+&CFTOKEN=\\d+)","replace":"preflayout=flat"}}},{"composite":{"name":"source","layer":"7","package":"ecologylab.semantics.generated.library.scholarlyPublication","type":"periodical","kids":[{"scalar":{"name":"title","style":"metadata_h1","layer":"10","navigates_to":"location","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"simpl.ref":"13594899"}},{"scalar":{"simpl.ref":"5127738"}},{"collection":{"simpl.id":"10609166","name":"authors","comment":"Set of authors.","layer":"8","schema_org_itemprop":"author","package":"ecologylab.semantics.generated.library.creativeWork","child_type":"author","kids":[{"composite":{"name":"author","package":"ecologylab.semantics.generated.library.creativeWork","type":"author","kids":[{"scalar":{"name":"title","style":"metadata_h1","layer":"10","navigates_to":"location","label":"name","is_facet":"True","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"simpl.ref":"29100051"}},{"scalar":{"simpl.ref":"46266773"}},{"scalar":{"simpl.ref":"2056392"}},{"scalar":{"simpl.ref":"39333393"}},{"collection":{"simpl.ref":"51103196"}},{"collection":{"simpl.ref":"17203224"}}]}}]}},{"scalar":{"simpl.ref":"17889527"}},{"scalar":{"simpl.ref":"62381978"}},{"scalar":{"simpl.ref":"7524288"}},{"composite":{"simpl.ref":"40060369"}},{"scalar":{"simpl.ref":"54434552"}},{"collection":{"simpl.ref":"51103196"}},{"composite":{"simpl.ref":"17224130"}},{"collection":{"simpl.ref":"17203224"}},{"scalar":{"name":"year","is_facet":"True","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataIntegerScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"39333393"}},{"collection":{"simpl.ref":"3419394"}},{"scalar":{"simpl.id":"30369281","name":"isbn","schema_org_itemprop":"author","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}}],"field_parser":{"name":"regex_find","regex":".*(\\d\\d\\d\\d).*"}}},{"scalar":{"simpl.ref":"17889527"}},{"scalar":{"simpl.ref":"62381978"}},{"collection":{"simpl.id":"48025404","name":"citations","comment":"Papers that cite this paper.","package":"ecologylab.semantics.generated.library.scholarlyPublication","child_tag":"citation","child_type":"scholarly_article","kids":[{"composite":{"name":"scholarly_article","tag":"citation","package":"ecologylab.semantics.generated.library.scholarlyPublication","type":"scholarly_article","kids":[{"composite":{"simpl.id":"65850542","name":"source","comment":"Metadata related to where this article was published.","layer":"7","package":"ecologylab.semantics.generated.library.scholarlyPublication","type":"periodical","kids":[{"scalar":{"simpl.ref":"35100727"}},{"scalar":{"simpl.ref":"13594899"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"simpl.ref":"5127738"}},{"collection":{"simpl.ref":"10609166"}},{"scalar":{"simpl.ref":"17889527"}},{"scalar":{"simpl.ref":"62381978"}},{"scalar":{"simpl.ref":"54434552"}},{"scalar":{"simpl.ref":"7524288"}},{"composite":{"simpl.ref":"17224130"}},{"collection":{"simpl.ref":"51103196"}},{"scalar":{"simpl.ref":"17194169"}},{"scalar":{"simpl.ref":"39333393"}},{"collection":{"simpl.ref":"17203224"}},{"scalar":{"simpl.ref":"30369281"}},{"composite":{"simpl.ref":"40060369"}},{"collection":{"simpl.ref":"3419394"}}]}},{"collection":{"simpl.id":"15517670","name":"classifications","comment":"The Classifications of this paper.","package":"ecologylab.semantics.generated.library.scholarlyPublication","child_type":"tag","kids":[{"composite":{"name":"tag","package":"ecologylab.semantics.generated.library.scholarlyPublication","type":"tag","kids":[{"scalar":{"simpl.id":"46965693","name":"tag_name","navigates_to":"link","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.id":"46545237","name":"link","hide":"True","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute"}},{"collection":{"simpl.ref":"17203224"}},{"scalar":{"simpl.ref":"39333393"}}]}}]}},{"collection":{"simpl.id":"29306526","name":"keywords","comment":"Key Terms of the paper.","schema_org_itemprop":"keywords","package":"ecologylab.semantics.generated.library.scholarlyPublication","child_type":"tag","kids":[{"composite":{"name":"tag","package":"ecologylab.semantics.generated.library.scholarlyPublication","type":"tag","kids":[{"scalar":{"simpl.ref":"46965693"}},{"scalar":{"simpl.ref":"46545237"}},{"collection":{"simpl.ref":"17203224"}},{"scalar":{"simpl.ref":"39333393"}}]}}]}},{"collection":{"simpl.ref":"48025404"}},{"scalar":{"simpl.ref":"33872309"}},{"collection":{"simpl.id":"6364529","name":"references","comment":"Papers cited by this paper.","package":"ecologylab.semantics.generated.library.scholarlyPublication","child_tag":"reference","child_type":"scholarly_article","kids":[{"composite":{"name":"scholarly_article","tag":"reference","package":"ecologylab.semantics.generated.library.scholarlyPublication","type":"scholarly_article","kids":[{"composite":{"simpl.ref":"65850542"}},{"collection":{"simpl.ref":"15517670"}},{"collection":{"simpl.ref":"29306526"}},{"collection":{"simpl.ref":"48025404"}},{"scalar":{"simpl.ref":"33872309"}},{"collection":{"simpl.ref":"6364529"}},{"scalar":{"simpl.id":"28465055","name":"pages","layer":"-1","navigates_to":"table_of_contents","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}}]}}]}},{"scalar":{"simpl.ref":"28465055"}}]}}]}},{"collection":{"simpl.ref":"15517670"}},{"collection":{"simpl.ref":"6364529"}},{"collection":{"simpl.ref":"29306526"}},{"scalar":{"simpl.ref":"33872309"}},{"collection":{"simpl.ref":"3419394"}},{"collection":{"simpl.ref":"17203224"}},{"scalar":{"simpl.ref":"17194169"}},{"scalar":{"simpl.ref":"39333393"}},{"collection":{"simpl.ref":"51103196"}},{"scalar":{"simpl.ref":"28465055"}}]}}],"field_parser":{"name":"acm_reference","for_each_element":"True"}}},{"collection":{"name":"keywords","xpath":"//div[@id='divtags']//a/span/ancestor::a","schema_org_itemprop":"keywords","package":"ecologylab.semantics.generated.library.scholarlyPublication","child_type":"tag","kids":[{"composite":{"name":"tag","package":"ecologylab.semantics.generated.library.scholarlyPublication","type":"tag","kids":[{"collection":{"simpl.ref":"17203224"}},{"scalar":{"simpl.ref":"39333393"}},{"scalar":{"name":"link","xpath":"./@href","hide":"True","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute"}},{"scalar":{"name":"tag_name","xpath":"./span/child::text()","navigates_to":"link","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}}]}}]}},{"collection":{"name":"classifications","xpath":"//h1/a/span[contains(text(), 'INDEX TERMS')]/ancestor::h1/following-sibling::div[@class='flatbody'][1]//a[not(@name)]","package":"ecologylab.semantics.generated.library.scholarlyPublication","child_type":"tag","kids":[{"composite":{"name":"tag","package":"ecologylab.semantics.generated.library.scholarlyPublication","type":"tag","kids":[{"collection":{"simpl.ref":"17203224"}},{"scalar":{"simpl.ref":"39333393"}},{"scalar":{"name":"link","xpath":"./@href","hide":"True","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute"}},{"scalar":{"name":"tag_name","xpath":"./child::text()","navigates_to":"link","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}}]}}]}},{"collection":{"name":"references","xpath":"//h1/a/span[contains(text(), 'REFERENCES')]/ancestor::h1/following-sibling::div[@class='flatbody'][1]//tr/td[3]","package":"ecologylab.semantics.generated.library.scholarlyPublication","child_tag":"reference","child_type":"scholarly_article","kids":[{"composite":{"name":"scholarly_article","tag":"reference","package":"ecologylab.semantics.generated.library.scholarlyPublication","type":"scholarly_article","kids":[{"scalar":{"name":"title","style":"metadata_h1","layer":"20","navigates_to":"location","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"simpl.ref":"13594899"}},{"collection":{"name":"authors","layer":"8","schema_org_itemprop":"author","package":"ecologylab.semantics.generated.library.creativeWork","child_type":"author","kids":[{"composite":{"name":"author","package":"ecologylab.semantics.generated.library.creativeWork","type":"author","kids":[{"scalar":{"name":"title","style":"metadata_h1","layer":"10","navigates_to":"location","label":"name","is_facet":"True","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"simpl.ref":"29100051"}},{"scalar":{"simpl.ref":"46266773"}},{"scalar":{"simpl.ref":"2056392"}},{"scalar":{"simpl.ref":"39333393"}},{"collection":{"simpl.ref":"51103196"}},{"collection":{"simpl.ref":"17203224"}}]}}],"field_parser":{"name":"regex_split","regex":"\\s,\\s","trim":"True"}}},{"scalar":{"name":"location","xpath":".//a[1]/@href","hide":"True","always_show":"True","layer":"8","schema_org_itemprop":"url","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataParsedURLScalarType","hint":"XmlAttribute","filter":{"regex":"(cfid=\\d+&cftoken=\\d+)|(CFID=\\d+&CFTOKEN=\\d+)","replace":"preflayout=flat"}}},{"composite":{"name":"source","layer":"7","package":"ecologylab.semantics.generated.library.scholarlyPublication","type":"periodical","kids":[{"scalar":{"name":"title","style":"metadata_h1","layer":"10","navigates_to":"location","schema_org_itemprop":"name","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"55110660"}},{"scalar":{"simpl.ref":"13594899"}},{"scalar":{"simpl.ref":"5127738"}},{"collection":{"simpl.ref":"10609166"}},{"scalar":{"simpl.ref":"17889527"}},{"scalar":{"simpl.ref":"62381978"}},{"scalar":{"simpl.ref":"7524288"}},{"composite":{"simpl.ref":"40060369"}},{"scalar":{"simpl.ref":"54434552"}},{"collection":{"simpl.ref":"51103196"}},{"composite":{"simpl.ref":"17224130"}},{"collection":{"simpl.ref":"17203224"}},{"scalar":{"name":"year","is_facet":"True","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataIntegerScalarType","hint":"XmlAttribute"}},{"scalar":{"simpl.ref":"39333393"}},{"collection":{"simpl.ref":"3419394"}},{"scalar":{"simpl.ref":"30369281"}}],"field_parser":{"name":"regex_find","regex":".*(\\d\\d\\d\\d).*"}}},{"scalar":{"simpl.ref":"17889527"}},{"scalar":{"simpl.ref":"62381978"}},{"collection":{"simpl.ref":"48025404"}},{"collection":{"simpl.ref":"15517670"}},{"collection":{"simpl.ref":"6364529"}},{"collection":{"simpl.ref":"29306526"}},{"scalar":{"simpl.ref":"33872309"}},{"collection":{"simpl.ref":"3419394"}},{"collection":{"simpl.ref":"17203224"}},{"scalar":{"simpl.ref":"17194169"}},{"scalar":{"simpl.ref":"39333393"}},{"collection":{"simpl.ref":"51103196"}},{"scalar":{"simpl.ref":"28465055"}}]}}],"field_parser":{"name":"acm_reference","for_each_element":"True"}}},{"scalar":{"name":"pages","xpath":"//h1/a/span[contains(text(), 'PUBLICATION')]/ancestor::h1/following-sibling::div[@class='flatbody'][1]//td[text()='Pages']/following-sibling::td","layer":"-1","navigates_to":"table_of_contents","scalar_type":"ecologylab.semantics.metadata.scalar.types.MetadataStringScalarType","hint":"XmlAttribute"}}],"selector":[{"url_stripped":"http://portal.acm.org/citation.cfm"},{"url_stripped":"http://dl.acm.org/citation.cfm"}],"semantic_actions":[{"get_field":{"name":"location"}},{"set_field":{"name":"metadata_page","value":"location"}},{"if":{"checks":[{"not_null":{"value":"location"}}],"nested_semantic_action_list":[{"parse_document":{"now":"True","arg":[{"value":"metadata","name":"document"},{"value":"location","name":"location"}]}}]}},{"get_field":{"name":"title"}},{"create_and_visualize_text_surrogate":{"arg":[{"value":"title","name":"text"}]}},{"get_field":{"name":"references"}},{"if":{"checks":[{"not_null":{"value":"references"}}],"nested_semantic_action_list":[{"for_each":{"collection":"references","as":"ref","nested_semantic_action_list":[{"get_field":{"object":"ref","name":"description"}},{"parse_document":{"arg":[{"value":"true","name":"ciatation_sig"},{"value":"description","name":"anchor_text"},{"value":"ref","name":"entity"}]}}]}}]}},{"get_field":{"name":"citations"}},{"if":{"checks":[{"not_null":{"value":"citations"}}],"nested_semantic_action_list":[{"for_each":{"collection":"citations","as":"cit","nested_semantic_action_list":[{"get_field":{"object":"cit","name":"location"}},{"get_field":{"object":"cit","name":"description"}},{"parse_document":{"arg":[{"value":"true","name":"citation_sig"},{"value":"description","name":"anchor_text"},{"value":"cit","name":"entity"}]}}]}}]}}],"url_generator":[{"type":"search","engine":"acm_portal","use_id":"title"}]}}

		MetaMetadataRepositoryLoader loader = new MetaMetadataRepositoryLoader();
		
		MetaMetadataRepository repo = loader.loadFromDir(MetaMetadataRepositoryInit.findRepositoryLocation(), Format.XML);

		SimplTypesScope.graphSwitch = GRAPH_SWITCH.ON;
		
		System.out.println("Javascript Translator");
		SimplTypesScope ts = MetaMetadataTranslationScope.get();

		MetaMetadata portalMMD = repo.getMMByName("acm_portal");
		
		SimplTypesScope.serialize(portalMMD, System.out, Format.JSON);
		//ts.deserialize(System.out, Format.JSON);

		JavascriptTranslator jst = new JavascriptTranslator();
		jst.translateToJavascript(new File("jscode/mmd.js"), ts);
	}
}