package com.kcdata.abe.bapi;
public class Yst_Bapi_Trn_ItemsType extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1396186757499L) ;

    private  Yst_Bapi_Trn_ItemsType.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.XSDL_COMPLEX_TYPE, "urn:sap-com:document:sap:rfc:functions", "YST_BAPI_TRN_ITEMS", 54, 0, com.kcdata.abe.bapi.Yst_Bapi_Trn_ItemsType.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "YST_BAPI_TRN_ITEMS", 870, 1740, -1, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_TRN_ITEMS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Transfer Items</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>870</ifr:internalLength1><ifr:internalLength2>1740</ifr:internalLength2></ifr:definition></ifr:container></s0:type>");
        descriptorSetElementProperties(descriptor, 0, "ITEM_RPH", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Item_Rph", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "ITEM_RPH", 0, 0, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ITEM_RPH\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Transfer Item RPH</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>0</ifr:offset1><ifr:offset2>0</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YTRN_ITEM_RPH\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 1, "ZZALERT_ID", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzalert_Id", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "10"}}, "ZZALERT_ID", 2, 4, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZALERT_ID\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Alert-id</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>2</ifr:offset1><ifr:offset2>4</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZALID\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 2, "ZZPOSNR", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzposnr", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "6"}}, "ZZPOSNR", 12, 24, -1, 6, 12, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZPOSNR\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Alert ID item no.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>12</ifr:offset1><ifr:offset2>24</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZPOSNR\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>6</ifr:length><ifr:internalLength1>6</ifr:internalLength1><ifr:internalLength2>12</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>6</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 3, "ZZOLD_PAXTTL", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzold_Paxttl", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "4"}}, "ZZOLD_PAXTTL", 18, 36, -1, 4, 8, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZOLD_PAXTTL\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">CRS-Pax Title</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>18</ifr:offset1><ifr:offset2>36</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZTITLE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>4</ifr:length><ifr:internalLength1>4</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>4</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 4, "ZZNEW_PAXTTL", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zznew_Paxttl", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "4"}}, "ZZNEW_PAXTTL", 22, 44, -1, 4, 8, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZNEW_PAXTTL\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">CRS-Pax Title</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>22</ifr:offset1><ifr:offset2>44</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZTITLE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>4</ifr:length><ifr:internalLength1>4</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>4</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 5, "ZZOLD_PAXNMFST", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzold_Paxnmfst", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "ZZOLD_PAXNMFST", 26, 52, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZOLD_PAXNMFST\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Old Information.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>26</ifr:offset1><ifr:offset2>52</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZOLDINF\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 6, "ZZNEW_PAXNMFST", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zznew_Paxnmfst", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "ZZNEW_PAXNMFST", 56, 112, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZNEW_PAXNMFST\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">New Information.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>56</ifr:offset1><ifr:offset2>112</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZNEWINF\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 7, "ZZOLD_PAXNMLST", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzold_Paxnmlst", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "ZZOLD_PAXNMLST", 86, 172, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZOLD_PAXNMLST\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Old Information.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>86</ifr:offset1><ifr:offset2>172</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZOLDINF\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 8, "ZZNEW_PAXNMLST", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zznew_Paxnmlst", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "ZZNEW_PAXNMLST", 116, 232, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZNEW_PAXNMLST\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">New Information.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>116</ifr:offset1><ifr:offset2>232</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZNEWINF\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 9, "ZZOLD_PAXAG", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzold_Paxag", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "3"}}, "ZZOLD_PAXAG", 146, 292, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZOLD_PAXAG\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Age Of Pax</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>146</ifr:offset1><ifr:offset2>292</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZAGEP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 10, "ZZNEW_PAXAG", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zznew_Paxag", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "3"}}, "ZZNEW_PAXAG", 149, 298, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZNEW_PAXAG\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Age Of Pax</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>149</ifr:offset1><ifr:offset2>298</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZAGEP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 11, "ZZDEL_PAX", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzdel_Pax", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "ZZDEL_PAX", 152, 304, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZDEL_PAX\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Old Information.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>152</ifr:offset1><ifr:offset2>304</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZOLDINF\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 12, "ZZOLD_DEP_DT", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:date", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzold_Dep_Dt", java.sql.Date.class, null, new java.lang.String[][]{}, "ZZOLD_DEP_DT", 182, 364, -1, 8, 16, -1, com.sap.mw.jco.JCO.TYPE_DATE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZOLD_DEP_DT\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Old Departure Date.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>182</ifr:offset1><ifr:offset2>364</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZOLDDEPDATE\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>DATS</ifr:type><ifr:abapType>D</ifr:abapType><ifr:length>8</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>16</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 13, "ZZNEW_DEP_DT", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:date", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zznew_Dep_Dt", java.sql.Date.class, null, new java.lang.String[][]{}, "ZZNEW_DEP_DT", 190, 380, -1, 8, 16, -1, com.sap.mw.jco.JCO.TYPE_DATE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZNEW_DEP_DT\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">New Departure Date.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>190</ifr:offset1><ifr:offset2>380</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZNEWDEPDATE\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>DATS</ifr:type><ifr:abapType>D</ifr:abapType><ifr:length>8</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>16</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 14, "ZZOLD_GTWAY", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzold_Gtway", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "ZZOLD_GTWAY", 198, 396, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZOLD_GTWAY\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Old Gate Way.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>198</ifr:offset1><ifr:offset2>396</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZOLDGTWAY\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 15, "ZZNEW_GTWAY", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zznew_Gtway", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "ZZNEW_GTWAY", 201, 402, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZNEW_GTWAY\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">New Gate Way.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>201</ifr:offset1><ifr:offset2>402</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZNEWGTWAY\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 16, "ZZOLD_DEST", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzold_Dest", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "ZZOLD_DEST", 204, 408, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZOLD_DEST\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Old Destination.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>204</ifr:offset1><ifr:offset2>408</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZOLDDESTN\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 17, "ZZNEW_DEST", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zznew_Dest", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "ZZNEW_DEST", 207, 414, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZNEW_DEST\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">New Destination.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>207</ifr:offset1><ifr:offset2>414</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZNEWDESTN\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 18, "ZZHOTEL_NEW", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzhotel_New", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "ZZHOTEL_NEW", 210, 420, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZHOTEL_NEW\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">New Hotel.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>210</ifr:offset1><ifr:offset2>420</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZNEWHOTEL\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 19, "ZZHOTEL_OLD", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzhotel_Old", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "ZZHOTEL_OLD", 240, 480, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZHOTEL_OLD\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Old Hotel.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>240</ifr:offset1><ifr:offset2>480</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZOLDHOTEL\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 20, "ZZHOTEL_VEND", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzhotel_Vend", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "ZZHOTEL_VEND", 270, 540, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZHOTEL_VEND\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Account Number of Vendor or Creditor</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>270</ifr:offset1><ifr:offset2>540</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"LIFNR\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength><ifr:conversionExit>ALPHA</ifr:conversionExit></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 21, "ZZGRND_VEND", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzgrnd_Vend", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "ZZGRND_VEND", 280, 560, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZGRND_VEND\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Ground Handler Vendor No.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>280</ifr:offset1><ifr:offset2>560</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZGRNDVEND\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength><ifr:conversionExit>ALPHA</ifr:conversionExit></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 22, "ZZOLD_DURA", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzold_Dura", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "ZZOLD_DURA", 290, 580, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZOLD_DURA\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Old Duration.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>290</ifr:offset1><ifr:offset2>580</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZOLDDURA\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 23, "ZZNEW_DURA", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zznew_Dura", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "ZZNEW_DURA", 292, 584, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZNEW_DURA\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">New Duration.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>292</ifr:offset1><ifr:offset2>584</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZNEWDURA\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 24, "ZZHOTEL", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzhotel", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "18"}}, "ZZHOTEL", 294, 588, -1, 18, 36, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZHOTEL\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Material Number</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>294</ifr:offset1><ifr:offset2>588</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"MATNR\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>18</ifr:length><ifr:internalLength1>18</ifr:internalLength1><ifr:internalLength2>36</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>18</ifr:outputLength><ifr:conversionExit>MATN1</ifr:conversionExit></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 25, "ZZGATEWAY", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzgateway", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "ZZGATEWAY", 312, 624, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZGATEWAY\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">gateway</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>312</ifr:offset1><ifr:offset2>624</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZGTWY\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 26, "ZZDESTN", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzdestn", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "ZZDESTN", 315, 630, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZDESTN\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Destination</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>315</ifr:offset1><ifr:offset2>630</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZDESTN\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 27, "ZZGATEWAY_2", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzgateway_2", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "ZZGATEWAY_2", 318, 636, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZGATEWAY_2\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">gateway</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>318</ifr:offset1><ifr:offset2>636</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZGTWY\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 28, "ZZDESTN_2", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzdestn_2", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "ZZDESTN_2", 321, 642, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZDESTN_2\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Destination</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>321</ifr:offset1><ifr:offset2>642</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZDESTN\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 29, "ZZFLT_NO", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzflt_No", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "4"}}, "ZZFLT_NO", 324, 648, -1, 4, 8, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZFLT_NO\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Flight number</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>324</ifr:offset1><ifr:offset2>648</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZFLTNO\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>4</ifr:length><ifr:internalLength1>4</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>4</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 30, "ZZFLT_NO_2", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzflt_No_2", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "4"}}, "ZZFLT_NO_2", 328, 656, -1, 4, 8, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZFLT_NO_2\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Flight number</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>328</ifr:offset1><ifr:offset2>656</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZFLTNO\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>4</ifr:length><ifr:internalLength1>4</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>4</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 31, "ZZARR_TIME", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:time", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzarr_Time", java.sql.Time.class, null, new java.lang.String[][]{}, "ZZARR_TIME", 332, 664, -1, 6, 12, -1, com.sap.mw.jco.JCO.TYPE_TIME, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZARR_TIME\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Arrival Time</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>332</ifr:offset1><ifr:offset2>664</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZARRTIME\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>TIMS</ifr:type><ifr:abapType>T</ifr:abapType><ifr:length>6</ifr:length><ifr:internalLength1>6</ifr:internalLength1><ifr:internalLength2>12</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>8</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 32, "ZZARR_TIME_2", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:time", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzarr_Time_2", java.sql.Time.class, null, new java.lang.String[][]{}, "ZZARR_TIME_2", 338, 676, -1, 6, 12, -1, com.sap.mw.jco.JCO.TYPE_TIME, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZARR_TIME_2\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Arrival Time</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>338</ifr:offset1><ifr:offset2>676</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZARRTIME\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>TIMS</ifr:type><ifr:abapType>T</ifr:abapType><ifr:length>6</ifr:length><ifr:internalLength1>6</ifr:internalLength1><ifr:internalLength2>12</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>8</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 33, "ZZARR_DATE", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:date", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzarr_Date", java.sql.Date.class, null, new java.lang.String[][]{}, "ZZARR_DATE", 344, 688, -1, 8, 16, -1, com.sap.mw.jco.JCO.TYPE_DATE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZARR_DATE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Arrival Date .</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>344</ifr:offset1><ifr:offset2>688</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZARRDATE\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>DATS</ifr:type><ifr:abapType>D</ifr:abapType><ifr:length>8</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>16</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 34, "ZZARR_DATE2", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:date", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzarr_Date2", java.sql.Date.class, null, new java.lang.String[][]{}, "ZZARR_DATE2", 352, 704, -1, 8, 16, -1, com.sap.mw.jco.JCO.TYPE_DATE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZARR_DATE2\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Arrival Date .</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>352</ifr:offset1><ifr:offset2>704</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZARRDATE\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>DATS</ifr:type><ifr:abapType>D</ifr:abapType><ifr:length>8</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>16</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 35, "ZZHOTEL_INFO", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzhotel_Info", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "35"}}, "ZZHOTEL_INFO", 360, 720, -1, 35, 70, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZHOTEL_INFO\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Hotel Information</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>360</ifr:offset1><ifr:offset2>720</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZHOTLE_INFO\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>35</ifr:length><ifr:internalLength1>35</ifr:internalLength1><ifr:internalLength2>70</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>35</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 36, "ZZLOCTEL", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzloctel", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "23"}}, "ZZLOCTEL", 395, 790, -1, 23, 46, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZLOCTEL\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Local Telephone No.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>395</ifr:offset1><ifr:offset2>790</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZLOCTEL\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>23</ifr:length><ifr:internalLength1>23</ifr:internalLength1><ifr:internalLength2>46</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>23</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 37, "ZZDSERVICE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzdservice", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "20"}}, "ZZDSERVICE", 418, 836, -1, 20, 40, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZDSERVICE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Delivery services</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>418</ifr:offset1><ifr:offset2>836</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZDSERVICE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>20</ifr:length><ifr:internalLength1>20</ifr:internalLength1><ifr:internalLength2>40</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>20</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 38, "ZZTA_ACNT", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzta_Acnt", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "20"}}, "ZZTA_ACNT", 438, 876, -1, 20, 40, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZTA_ACNT\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Travel agency a/c number</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>438</ifr:offset1><ifr:offset2>876</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZTA_ACNT\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>20</ifr:length><ifr:internalLength1>20</ifr:internalLength1><ifr:internalLength2>40</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>20</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 39, "ZZNAMES", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zznames", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "ZZNAMES", 458, 916, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZNAMES\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Name</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>458</ifr:offset1><ifr:offset2>916</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"NAME1\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 40, "ZZSTADDRESS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzstaddress", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "35"}}, "ZZSTADDRESS", 488, 976, -1, 35, 70, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZSTADDRESS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">House number and street</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>488</ifr:offset1><ifr:offset2>976</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"STRAS_GP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>35</ifr:length><ifr:internalLength1>35</ifr:internalLength1><ifr:internalLength2>70</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>35</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 41, "ZZCITY", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzcity", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "35"}}, "ZZCITY", 523, 1046, -1, 35, 70, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZCITY\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">City</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>523</ifr:offset1><ifr:offset2>1046</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ORT01_GP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>35</ifr:length><ifr:internalLength1>35</ifr:internalLength1><ifr:internalLength2>70</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>35</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 42, "ZZSTATE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzstate", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "25"}}, "ZZSTATE", 558, 1116, -1, 25, 50, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZSTATE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">State.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>558</ifr:offset1><ifr:offset2>1116</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZSTATE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>25</ifr:length><ifr:internalLength1>25</ifr:internalLength1><ifr:internalLength2>50</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>25</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 43, "ZZZIP_CODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzzip_Code", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "ZZZIP_CODE", 583, 1166, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZZIP_CODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Postal Code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>583</ifr:offset1><ifr:offset2>1166</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"PSTLZ\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 44, "ZZCOMMENTS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzcomments", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "255"}}, "ZZCOMMENTS", 593, 1186, -1, 255, 510, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZCOMMENTS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Text.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>593</ifr:offset1><ifr:offset2>1186</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZTEXT\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>255</ifr:length><ifr:internalLength1>255</ifr:internalLength1><ifr:internalLength2>510</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>255</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 45, "ZZAL_CODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzal_Code", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "2"}}, "ZZAL_CODE", 848, 1696, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZAL_CODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Airline Code 2 Digits</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>848</ifr:offset1><ifr:offset2>1696</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZALCODE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 46, "ZZAL_CODE_2", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzal_Code_2", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "2"}}, "ZZAL_CODE_2", 850, 1700, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZAL_CODE_2\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Airline Code 2 Digits</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>850</ifr:offset1><ifr:offset2>1700</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZALCODE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 47, "ZZDEP_TIME", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:time", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzdep_Time", java.sql.Time.class, null, new java.lang.String[][]{}, "ZZDEP_TIME", 852, 1704, -1, 6, 12, -1, com.sap.mw.jco.JCO.TYPE_TIME, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZDEP_TIME\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Departure Time</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>852</ifr:offset1><ifr:offset2>1704</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZDEPTIME\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>TIMS</ifr:type><ifr:abapType>T</ifr:abapType><ifr:length>6</ifr:length><ifr:internalLength1>6</ifr:internalLength1><ifr:internalLength2>12</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>8</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 48, "ZZFLTCLASS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzfltclass", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "2"}}, "ZZFLTCLASS", 858, 1716, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZFLTCLASS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Flight class</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>858</ifr:offset1><ifr:offset2>1716</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZFLTCLASS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 49, "ZZTKTIND", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zztktind", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "ZZTKTIND", 860, 1720, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZTKTIND\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Ticketed indicator (Y/N)</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>860</ifr:offset1><ifr:offset2>1720</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZTKTIND\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 50, "ZZPNRNO", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzpnrno", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "6"}}, "ZZPNRNO", 861, 1722, -1, 6, 12, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZPNRNO\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">PNR number</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>861</ifr:offset1><ifr:offset2>1722</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZPNRNO\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>6</ifr:length><ifr:internalLength1>6</ifr:internalLength1><ifr:internalLength2>12</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>6</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 51, "ZZTRANSFERINFO", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zztransferinfo", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "ZZTRANSFERINFO", 867, 1734, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZTRANSFERINFO\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Radio button for declining transfer</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>867</ifr:offset1><ifr:offset2>1734</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZTRANSFERINFO\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 52, "ZZDECLINETR", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zzdeclinetr", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "ZZDECLINETR", 868, 1736, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZDECLINETR\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Radio button for declining transfer</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>868</ifr:offset1><ifr:offset2>1736</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZDECLINETR\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 53, "ZZTEMPTRANSFER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zztemptransfer", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "ZZTEMPTRANSFER", 869, 1738, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ZZTEMPTRANSFER\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Radio button for temporary transfer</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>869</ifr:offset1><ifr:offset2>1738</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZTEMPTRANSFER\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        staticDescriptor = descriptor;
    }
    public  Yst_Bapi_Trn_ItemsType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Yst_Bapi_Trn_ItemsType (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setZzdestn_2(java.lang.String Zzdestn_2) {
        baseTypeData().setElementValue(28, Zzdestn_2);
    }

    public void setZzold_Dest(java.lang.String Zzold_Dest) {
        baseTypeData().setElementValue(16, Zzold_Dest);
    }

    public java.lang.String getZznew_Paxnmfst() {
        return (java.lang.String)baseTypeData().getElementValueAsString(6);
    }

    public void setZzarr_Date2(java.sql.Date Zzarr_Date2) {
        baseTypeData().setElementValue(34, Zzarr_Date2);
    }

    public java.lang.String getZzold_Paxnmlst() {
        return (java.lang.String)baseTypeData().getElementValueAsString(7);
    }

    public java.sql.Time getZzarr_Time_2() {
        return (java.sql.Time)baseTypeData().getElementValueAsTime(32);
    }

    public void setZzta_Acnt(java.lang.String Zzta_Acnt) {
        baseTypeData().setElementValue(38, Zzta_Acnt);
    }

    public void setZzflt_No(java.lang.String Zzflt_No) {
        baseTypeData().setElementValue(29, Zzflt_No);
    }

    public void setZzpnrno(java.lang.String Zzpnrno) {
        baseTypeData().setElementValue(50, Zzpnrno);
    }

    public java.lang.String getZzold_Dura() {
        return (java.lang.String)baseTypeData().getElementValueAsString(22);
    }

    public void setZzfltclass(java.lang.String Zzfltclass) {
        baseTypeData().setElementValue(48, Zzfltclass);
    }

    public java.lang.String getZzdservice() {
        return (java.lang.String)baseTypeData().getElementValueAsString(37);
    }

    public void setZznew_Paxnmlst(java.lang.String Zznew_Paxnmlst) {
        baseTypeData().setElementValue(8, Zznew_Paxnmlst);
    }

    public void setZznew_Paxttl(java.lang.String Zznew_Paxttl) {
        baseTypeData().setElementValue(4, Zznew_Paxttl);
    }

    public java.sql.Time getZzarr_Time() {
        return (java.sql.Time)baseTypeData().getElementValueAsTime(31);
    }

    public void setZznames(java.lang.String Zznames) {
        baseTypeData().setElementValue(39, Zznames);
    }

    public java.lang.String getZzhotel_New() {
        return (java.lang.String)baseTypeData().getElementValueAsString(18);
    }

    public void setZzgateway(java.lang.String Zzgateway) {
        baseTypeData().setElementValue(25, Zzgateway);
    }

    public void setZzarr_Time_2(java.sql.Time Zzarr_Time_2) {
        baseTypeData().setElementValue(32, Zzarr_Time_2);
    }

    public java.lang.String getZznew_Paxag() {
        return (java.lang.String)baseTypeData().getElementValueAsString(10);
    }

    public void setZzcomments(java.lang.String Zzcomments) {
        baseTypeData().setElementValue(44, Zzcomments);
    }

    public java.lang.String getZzold_Dest() {
        return (java.lang.String)baseTypeData().getElementValueAsString(16);
    }

    public void setZzold_Paxag(java.lang.String Zzold_Paxag) {
        baseTypeData().setElementValue(9, Zzold_Paxag);
    }

    public java.sql.Date getZzold_Dep_Dt() {
        return (java.sql.Date)baseTypeData().getElementValueAsDate(12);
    }

    public void setZzhotel(java.lang.String Zzhotel) {
        baseTypeData().setElementValue(24, Zzhotel);
    }

    public java.lang.String getZzflt_No() {
        return (java.lang.String)baseTypeData().getElementValueAsString(29);
    }

    public java.lang.String getZzfltclass() {
        return (java.lang.String)baseTypeData().getElementValueAsString(48);
    }

    public java.lang.String getZznew_Paxnmlst() {
        return (java.lang.String)baseTypeData().getElementValueAsString(8);
    }

    public java.lang.String getZznew_Paxttl() {
        return (java.lang.String)baseTypeData().getElementValueAsString(4);
    }

    public java.sql.Time getZzdep_Time() {
        return (java.sql.Time)baseTypeData().getElementValueAsTime(47);
    }

    public void setZzposnr(java.lang.String Zzposnr) {
        baseTypeData().setElementValue(2, Zzposnr);
    }

    public void setZzgateway_2(java.lang.String Zzgateway_2) {
        baseTypeData().setElementValue(27, Zzgateway_2);
    }

    public void setZzstaddress(java.lang.String Zzstaddress) {
        baseTypeData().setElementValue(40, Zzstaddress);
    }

    public java.lang.String getZzcomments() {
        return (java.lang.String)baseTypeData().getElementValueAsString(44);
    }

    public java.sql.Date getZzarr_Date() {
        return (java.sql.Date)baseTypeData().getElementValueAsDate(33);
    }

    public java.lang.String getZzal_Code_2() {
        return (java.lang.String)baseTypeData().getElementValueAsString(46);
    }

    public void setZzgrnd_Vend(java.lang.String Zzgrnd_Vend) {
        baseTypeData().setElementValue(21, Zzgrnd_Vend);
    }

    public void setZznew_Gtway(java.lang.String Zznew_Gtway) {
        baseTypeData().setElementValue(15, Zznew_Gtway);
    }

    public void setZzalert_Id(java.lang.String Zzalert_Id) {
        baseTypeData().setElementValue(1, Zzalert_Id);
    }

    public void setZzal_Code(java.lang.String Zzal_Code) {
        baseTypeData().setElementValue(45, Zzal_Code);
    }

    public java.lang.String getZzdestn() {
        return (java.lang.String)baseTypeData().getElementValueAsString(26);
    }

    public java.lang.String getZzhotel_Old() {
        return (java.lang.String)baseTypeData().getElementValueAsString(19);
    }

    public void setZztktind(java.lang.String Zztktind) {
        baseTypeData().setElementValue(49, Zztktind);
    }

    public java.lang.String getZzdeclinetr() {
        return (java.lang.String)baseTypeData().getElementValueAsString(52);
    }

    public java.lang.String getZzdel_Pax() {
        return (java.lang.String)baseTypeData().getElementValueAsString(11);
    }

    public void setZzdep_Time(java.sql.Time Zzdep_Time) {
        baseTypeData().setElementValue(47, Zzdep_Time);
    }

    public void setItem_Rph(java.lang.String Item_Rph) {
        baseTypeData().setElementValue(0, Item_Rph);
    }

    public java.lang.String getZzstate() {
        return (java.lang.String)baseTypeData().getElementValueAsString(42);
    }

    public java.lang.String getZzold_Gtway() {
        return (java.lang.String)baseTypeData().getElementValueAsString(14);
    }

    public java.lang.String getZzalert_Id() {
        return (java.lang.String)baseTypeData().getElementValueAsString(1);
    }

    public void setZzhotel_New(java.lang.String Zzhotel_New) {
        baseTypeData().setElementValue(18, Zzhotel_New);
    }

    public java.lang.String getZzdestn_2() {
        return (java.lang.String)baseTypeData().getElementValueAsString(28);
    }

    public void setZzcity(java.lang.String Zzcity) {
        baseTypeData().setElementValue(41, Zzcity);
    }

    public void setZzzip_Code(java.lang.String Zzzip_Code) {
        baseTypeData().setElementValue(43, Zzzip_Code);
    }

    public void setZznew_Paxag(java.lang.String Zznew_Paxag) {
        baseTypeData().setElementValue(10, Zznew_Paxag);
    }

    public java.lang.String getZzta_Acnt() {
        return (java.lang.String)baseTypeData().getElementValueAsString(38);
    }

    public void setZzold_Dep_Dt(java.sql.Date Zzold_Dep_Dt) {
        baseTypeData().setElementValue(12, Zzold_Dep_Dt);
    }

    public java.lang.String getZzpnrno() {
        return (java.lang.String)baseTypeData().getElementValueAsString(50);
    }

    public void setZznew_Dura(java.lang.String Zznew_Dura) {
        baseTypeData().setElementValue(23, Zznew_Dura);
    }

    public void setZzold_Paxttl(java.lang.String Zzold_Paxttl) {
        baseTypeData().setElementValue(3, Zzold_Paxttl);
    }

    public java.lang.String getZztktind() {
        return (java.lang.String)baseTypeData().getElementValueAsString(49);
    }

    public void setZzloctel(java.lang.String Zzloctel) {
        baseTypeData().setElementValue(36, Zzloctel);
    }

    public void setZztransferinfo(java.lang.String Zztransferinfo) {
        baseTypeData().setElementValue(51, Zztransferinfo);
    }

    public void setZzold_Paxnmfst(java.lang.String Zzold_Paxnmfst) {
        baseTypeData().setElementValue(5, Zzold_Paxnmfst);
    }

    public java.sql.Date getZznew_Dep_Dt() {
        return (java.sql.Date)baseTypeData().getElementValueAsDate(13);
    }

    public java.lang.String getItem_Rph() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public java.lang.String getZznames() {
        return (java.lang.String)baseTypeData().getElementValueAsString(39);
    }

    public java.lang.String getZzgateway() {
        return (java.lang.String)baseTypeData().getElementValueAsString(25);
    }

    public void setZzhotel_Vend(java.lang.String Zzhotel_Vend) {
        baseTypeData().setElementValue(20, Zzhotel_Vend);
    }

    public void setZzflt_No_2(java.lang.String Zzflt_No_2) {
        baseTypeData().setElementValue(30, Zzflt_No_2);
    }

    public java.lang.String getZzcity() {
        return (java.lang.String)baseTypeData().getElementValueAsString(41);
    }

    public java.lang.String getZzzip_Code() {
        return (java.lang.String)baseTypeData().getElementValueAsString(43);
    }

    public java.lang.String getZzold_Paxag() {
        return (java.lang.String)baseTypeData().getElementValueAsString(9);
    }

    public java.lang.String getZzhotel() {
        return (java.lang.String)baseTypeData().getElementValueAsString(24);
    }

    public void setZznew_Dest(java.lang.String Zznew_Dest) {
        baseTypeData().setElementValue(17, Zznew_Dest);
    }

    public void setZztemptransfer(java.lang.String Zztemptransfer) {
        baseTypeData().setElementValue(53, Zztemptransfer);
    }

    public void setZznew_Dep_Dt(java.sql.Date Zznew_Dep_Dt) {
        baseTypeData().setElementValue(13, Zznew_Dep_Dt);
    }

    public void setZzhotel_Info(java.lang.String Zzhotel_Info) {
        baseTypeData().setElementValue(35, Zzhotel_Info);
    }

    public java.lang.String getZznew_Dura() {
        return (java.lang.String)baseTypeData().getElementValueAsString(23);
    }

    public java.lang.String getZzold_Paxttl() {
        return (java.lang.String)baseTypeData().getElementValueAsString(3);
    }

    public java.lang.String getZzloctel() {
        return (java.lang.String)baseTypeData().getElementValueAsString(36);
    }

    public java.lang.String getZztransferinfo() {
        return (java.lang.String)baseTypeData().getElementValueAsString(51);
    }

    public java.lang.String getZzold_Paxnmfst() {
        return (java.lang.String)baseTypeData().getElementValueAsString(5);
    }

    public void setZzal_Code_2(java.lang.String Zzal_Code_2) {
        baseTypeData().setElementValue(46, Zzal_Code_2);
    }

    public java.lang.String getZzhotel_Vend() {
        return (java.lang.String)baseTypeData().getElementValueAsString(20);
    }

    public void setZzdestn(java.lang.String Zzdestn) {
        baseTypeData().setElementValue(26, Zzdestn);
    }

    public java.lang.String getZzposnr() {
        return (java.lang.String)baseTypeData().getElementValueAsString(2);
    }

    public java.lang.String getZzgateway_2() {
        return (java.lang.String)baseTypeData().getElementValueAsString(27);
    }

    public void setZznew_Paxnmfst(java.lang.String Zznew_Paxnmfst) {
        baseTypeData().setElementValue(6, Zznew_Paxnmfst);
    }

    public java.lang.String getZzstaddress() {
        return (java.lang.String)baseTypeData().getElementValueAsString(40);
    }

    public void setZzold_Paxnmlst(java.lang.String Zzold_Paxnmlst) {
        baseTypeData().setElementValue(7, Zzold_Paxnmlst);
    }

    public java.lang.String getZzflt_No_2() {
        return (java.lang.String)baseTypeData().getElementValueAsString(30);
    }

    public java.lang.String getZznew_Dest() {
        return (java.lang.String)baseTypeData().getElementValueAsString(17);
    }

    public java.lang.String getZztemptransfer() {
        return (java.lang.String)baseTypeData().getElementValueAsString(53);
    }

    public void setZzold_Dura(java.lang.String Zzold_Dura) {
        baseTypeData().setElementValue(22, Zzold_Dura);
    }

    public void setZzhotel_Old(java.lang.String Zzhotel_Old) {
        baseTypeData().setElementValue(19, Zzhotel_Old);
    }

    public java.sql.Date getZzarr_Date2() {
        return (java.sql.Date)baseTypeData().getElementValueAsDate(34);
    }

    public MetaData metadata() {
        return metadata;
    }

    public java.lang.String getZzhotel_Info() {
        return (java.lang.String)baseTypeData().getElementValueAsString(35);
    }

    public void setZzarr_Time(java.sql.Time Zzarr_Time) {
        baseTypeData().setElementValue(31, Zzarr_Time);
    }

    public void setZzdservice(java.lang.String Zzdservice) {
        baseTypeData().setElementValue(37, Zzdservice);
    }

    public void setZzdeclinetr(java.lang.String Zzdeclinetr) {
        baseTypeData().setElementValue(52, Zzdeclinetr);
    }

    public java.lang.String getZzgrnd_Vend() {
        return (java.lang.String)baseTypeData().getElementValueAsString(21);
    }

    public java.lang.String getZznew_Gtway() {
        return (java.lang.String)baseTypeData().getElementValueAsString(15);
    }

    public void setZzdel_Pax(java.lang.String Zzdel_Pax) {
        baseTypeData().setElementValue(11, Zzdel_Pax);
    }

    public void setZzarr_Date(java.sql.Date Zzarr_Date) {
        baseTypeData().setElementValue(33, Zzarr_Date);
    }

    public java.lang.String getZzal_Code() {
        return (java.lang.String)baseTypeData().getElementValueAsString(45);
    }

    public void setZzstate(java.lang.String Zzstate) {
        baseTypeData().setElementValue(42, Zzstate);
    }

    public void setZzold_Gtway(java.lang.String Zzold_Gtway) {
        baseTypeData().setElementValue(14, Zzold_Gtway);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Yst_Bapi_Trn_ItemsType parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Yst_Bapi_Trn_ItemsType parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZznew_Paxnmfst() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzold_Paxnmlst() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzold_Gtway() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(14);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzalert_Id() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzarr_Time_2() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(32);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzold_Dura() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(22);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzdestn_2() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(28);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzdservice() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(37);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzta_Acnt() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(38);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzarr_Time() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(31);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzpnrno() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(50);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzhotel_New() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(18);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZztktind() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(49);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZznew_Paxag() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(10);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZznew_Dep_Dt() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(13);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getItem_Rph() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZznames() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(39);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzold_Dest() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(16);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzold_Dep_Dt() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(12);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzgateway() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(25);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzflt_No() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(29);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzcity() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(41);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzzip_Code() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(43);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzfltclass() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(48);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzold_Paxag() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzhotel() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(24);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZznew_Paxnmlst() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZznew_Paxttl() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZznew_Dura() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(23);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzold_Paxttl() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzdep_Time() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(47);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzloctel() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(36);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZztransferinfo() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(51);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzold_Paxnmfst() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzcomments() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(44);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzhotel_Vend() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(20);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzposnr() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzarr_Date() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(33);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzgateway_2() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(27);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzal_Code_2() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(46);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzstaddress() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(40);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzflt_No_2() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(30);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZznew_Dest() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(17);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzdestn() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(26);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZztemptransfer() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(53);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzarr_Date2() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(34);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzhotel_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(35);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzgrnd_Vend() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(21);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZznew_Gtway() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(15);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzal_Code() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(45);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzhotel_Old() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(19);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzdeclinetr() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(52);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzdel_Pax() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(11);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZzstate() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(42);
        }
    
    }

}
