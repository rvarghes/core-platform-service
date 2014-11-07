package com.kcdata.abe.bapi;
public class Y_Ota_Retrieve_Quote_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1341668185344L) ;

    private  Y_Ota_Retrieve_Quote_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_RETRIEVE_QUOTE.Input", 14, 0, com.kcdata.abe.bapi.Y_Ota_Retrieve_Quote_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_OTA_RETRIEVE_QUOTE", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Retrieve Quote</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "CH_ST_BAPI_METADATA", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_METADATA", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ch_St_Bapi_Metadata", com.kcdata.abe.bapi.Yst_MetadataType.class, new com.kcdata.abe.bapi.Yst_MetadataType(), new java.lang.String[][]{}, "CH_ST_BAPI_METADATA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER | com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CH_ST_BAPI_METADATA\"><ifr:descriptor><ifr:description language=\"EN\">Matadata for BAPI Request Interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_METADATA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_METADATA\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>changing</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IM_APPLICATION_INFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_APPLI_INFO", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Application_Info", com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType.class, new com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType(), new java.lang.String[][]{}, "IM_APPLICATION_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_APPLICATION_INFO\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Application Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_APPLI_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_APPLI_INFO\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IM_ST_QUOTESEARCH", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_QUOTESEARCH", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_St_Quotesearch", com.kcdata.abe.bapi.Yst_Bapi_QuotesearchType.class, new com.kcdata.abe.bapi.Yst_Bapi_QuotesearchType(), new java.lang.String[][]{}, "IM_ST_QUOTESEARCH", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_ST_QUOTESEARCH\"><ifr:descriptor><ifr:description language=\"EN\">Quotation Search Criteria</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_QUOTESEARCH\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_QUOTESEARCH\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_VEH_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Veh_Items", com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Veh_ItemsType(), new java.lang.String[][]{}, "IT_VEH_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_VEH_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">Vehicle Items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_VEH_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_VEH_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_SER_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ser_Items", com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Ser_ItemsType(), new java.lang.String[][]{}, "IT_SER_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_SER_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">Services items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_SER_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_SER_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 6, "IT_PAX_PRICING", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Pax_Pricing", com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType(), new java.lang.String[][]{}, "IT_PAX_PRICING", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_PAX_PRICING\"><ifr:descriptor><ifr:description language=\"EN\">OTA  Pax Pricing</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_PAX_PRICING\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_PAX_PRICING\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 7, "IT_INS_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ins_Items", com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType(), new java.lang.String[][]{}, "IT_INS_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_INS_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">Insurance items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_INS_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_INS_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 8, "IT_HTL_ROOMSTAYCANDIDATES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Roomstaycandidates", com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List.class, new com.kcdata.abe.bapi.Yst_Ota_RoomstaycandidatesType(), new java.lang.String[][]{}, "IT_HTL_ROOMSTAYCANDIDATES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_ROOMSTAYCANDIDATES\"><ifr:descriptor><ifr:description language=\"EN\">OTA  Roomstay Candidates</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_ROOMSTAYCANDIDATES\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_ROOMSTAYCANDIDATES\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 9, "IT_HTL_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Items", com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType(), new java.lang.String[][]{}, "IT_HTL_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">Hotel items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 10, "IT_GUESTINFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Guestinfo", com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List.class, new com.kcdata.abe.bapi.Yst_Ota_GuestinfoType(), new java.lang.String[][]{}, "IT_GUESTINFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_GUESTINFO\"><ifr:descriptor><ifr:description language=\"EN\">OTA Passenger Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_GUESTINFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_GUESTINFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 11, "IT_FLT_SEGMENTS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Flt_Segments", com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType(), new java.lang.String[][]{}, "IT_FLT_SEGMENTS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_FLT_SEGMENTS\"><ifr:descriptor><ifr:description language=\"EN\">Flight Segments</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLT_SEGMENTS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLT_SEGMENTS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 12, "IT_FLT_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Flt_Items", com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType(), new java.lang.String[][]{}, "IT_FLT_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_FLT_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">Flight Items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLT_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLT_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 13, "IT_CHARGES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Charges", com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List.class, new com.kcdata.abe.bapi.Yst_Ota_ChargesType(), new java.lang.String[][]{}, "IT_CHARGES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_CHARGES\"><ifr:descriptor><ifr:description language=\"EN\">OTA Booking Charges</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_CHARGES\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_CHARGES\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Y_Ota_Retrieve_Quote_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Y_Ota_Retrieve_Quote_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void setIm_St_Quotesearch(com.kcdata.abe.bapi.Yst_Bapi_QuotesearchType Im_St_Quotesearch) {
        baseTypeData().setElementValue(2, Im_St_Quotesearch);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType[] getIt_Ins_Items() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List)baseTypeData().getElementValue(7);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Ins_ItemsType();
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType[] getIt_Flt_Items() {
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List)baseTypeData().getElementValue(12);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Flt_ItemsType();
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List get_as_listIt_Ser_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List)baseTypeData().getElementValue(4);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List get_as_listIt_Htl_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List)baseTypeData().getElementValue(9);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List get_as_listIt_Charges() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List)baseTypeData().getElementValue(13);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_QuotesearchType getIm_St_Quotesearch() {
        return (com.kcdata.abe.bapi.Yst_Bapi_QuotesearchType)baseTypeData().getElementValue(2);
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(5, It_Return);
    }

    public void setIt_Pax_Pricing(com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType[] It_Pax_Pricing) {
        baseTypeData().setElementValue(6, new com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List list$ = get_as_listIt_Pax_Pricing();
        for (int  i$ = 0; i$ < It_Pax_Pricing.length; i$++){
         list$.addYst_Ota_Pax_PricingType(It_Pax_Pricing[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(5);
    }

    public void setIt_Flt_Items(com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType[] It_Flt_Items) {
        baseTypeData().setElementValue(12, new com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List list$ = get_as_listIt_Flt_Items();
        for (int  i$ = 0; i$ < It_Flt_Items.length; i$++){
         list$.addYst_Ota_Flt_ItemsType(It_Flt_Items[ i$]);
        }
    }

    public void setIm_Application_Info(com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType Im_Application_Info) {
        baseTypeData().setElementValue(1, Im_Application_Info);
    }

    public MetaData metadataY_Ota_Retrieve_Quote_Input() {
        return metadata;
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List get_as_listIt_Pax_Pricing() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List)baseTypeData().getElementValue(6);
    }

    public void setIt_Flt_Items(com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List It_Flt_Items) {
        baseTypeData().setElementValue(12, It_Flt_Items);
    }

    public void setIt_Charges(com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List It_Charges) {
        baseTypeData().setElementValue(13, It_Charges);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List get_as_listIt_Guestinfo() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List)baseTypeData().getElementValue(10);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType[] getIt_Flt_Segments() {
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List)baseTypeData().getElementValue(11);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Flt_SegmentsType();
    }

    public void setIt_Veh_Items(com.kcdata.abe.bapi.Yst_Ota_Veh_ItemsType[] It_Veh_Items) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List list$ = get_as_listIt_Veh_Items();
        for (int  i$ = 0; i$ < It_Veh_Items.length; i$++){
         list$.addYst_Ota_Veh_ItemsType(It_Veh_Items[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List get_as_listIt_Veh_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List)baseTypeData().getElementValue(3);
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List get_as_listIt_Ins_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List)baseTypeData().getElementValue(7);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List get_as_listIt_Flt_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List)baseTypeData().getElementValue(12);
    }

    public void setIt_Pax_Pricing(com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List It_Pax_Pricing) {
        baseTypeData().setElementValue(6, It_Pax_Pricing);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List get_as_listIt_Htl_Roomstaycandidates() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List)baseTypeData().getElementValue(8);
    }

    public void setIt_Guestinfo(com.kcdata.abe.bapi.Yst_Ota_GuestinfoType[] It_Guestinfo) {
        baseTypeData().setElementValue(10, new com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List list$ = get_as_listIt_Guestinfo();
        for (int  i$ = 0; i$ < It_Guestinfo.length; i$++){
         list$.addYst_Ota_GuestinfoType(It_Guestinfo[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(5);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public void setIt_Ins_Items(com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List It_Ins_Items) {
        baseTypeData().setElementValue(7, It_Ins_Items);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Ser_ItemsType[] getIt_Ser_Items() {
        com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Ser_ItemsType();
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType[] getIt_Htl_Items() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List)baseTypeData().getElementValue(9);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_ItemsType();
    }

    public com.kcdata.abe.bapi.Yst_Ota_ChargesType[] getIt_Charges() {
        com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List)baseTypeData().getElementValue(13);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_ChargesType();
    }

    public void setIt_Flt_Segments(com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType[] It_Flt_Segments) {
        baseTypeData().setElementValue(11, new com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List list$ = get_as_listIt_Flt_Segments();
        for (int  i$ = 0; i$ < It_Flt_Segments.length; i$++){
         list$.addYst_Ota_Flt_SegmentsType(It_Flt_Segments[ i$]);
        }
    }

    public void setIt_Ser_Items(com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List It_Ser_Items) {
        baseTypeData().setElementValue(4, It_Ser_Items);
    }

    public void setIt_Htl_Items(com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List It_Htl_Items) {
        baseTypeData().setElementValue(9, It_Htl_Items);
    }

    public void setIt_Flt_Segments(com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List It_Flt_Segments) {
        baseTypeData().setElementValue(11, It_Flt_Segments);
    }

    public void setCh_St_Bapi_Metadata(com.kcdata.abe.bapi.Yst_MetadataType Ch_St_Bapi_Metadata) {
        baseTypeData().setElementValue(0, Ch_St_Bapi_Metadata);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType[] getIt_Pax_Pricing() {
        com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List)baseTypeData().getElementValue(6);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Pax_PricingType();
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(5, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_GuestinfoType[] getIt_Guestinfo() {
        com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List)baseTypeData().getElementValue(10);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_GuestinfoType();
    }

    public void setIt_Ins_Items(com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType[] It_Ins_Items) {
        baseTypeData().setElementValue(7, new com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List list$ = get_as_listIt_Ins_Items();
        for (int  i$ = 0; i$ < It_Ins_Items.length; i$++){
         list$.addYst_Bapi_Ins_ItemsType(It_Ins_Items[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List get_as_listIt_Flt_Segments() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List)baseTypeData().getElementValue(11);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType getIm_Application_Info() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType)baseTypeData().getElementValue(1);
    }

    public void setIt_Charges(com.kcdata.abe.bapi.Yst_Ota_ChargesType[] It_Charges) {
        baseTypeData().setElementValue(13, new com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List list$ = get_as_listIt_Charges();
        for (int  i$ = 0; i$ < It_Charges.length; i$++){
         list$.addYst_Ota_ChargesType(It_Charges[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_RoomstaycandidatesType[] getIt_Htl_Roomstaycandidates() {
        com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List)baseTypeData().getElementValue(8);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_RoomstaycandidatesType();
    }

    public void setIt_Htl_Roomstaycandidates(com.kcdata.abe.bapi.Yst_Ota_RoomstaycandidatesType[] It_Htl_Roomstaycandidates) {
        baseTypeData().setElementValue(8, new com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List list$ = get_as_listIt_Htl_Roomstaycandidates();
        for (int  i$ = 0; i$ < It_Htl_Roomstaycandidates.length; i$++){
         list$.addYst_Ota_RoomstaycandidatesType(It_Htl_Roomstaycandidates[ i$]);
        }
    }

    public void setIt_Ser_Items(com.kcdata.abe.bapi.Yst_Ota_Ser_ItemsType[] It_Ser_Items) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List list$ = get_as_listIt_Ser_Items();
        for (int  i$ = 0; i$ < It_Ser_Items.length; i$++){
         list$.addYst_Ota_Ser_ItemsType(It_Ser_Items[ i$]);
        }
    }

    public void setIt_Htl_Roomstaycandidates(com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List It_Htl_Roomstaycandidates) {
        baseTypeData().setElementValue(8, It_Htl_Roomstaycandidates);
    }

    public void setIt_Htl_Items(com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType[] It_Htl_Items) {
        baseTypeData().setElementValue(9, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List list$ = get_as_listIt_Htl_Items();
        for (int  i$ = 0; i$ < It_Htl_Items.length; i$++){
         list$.addYst_Ota_Htl_ItemsType(It_Htl_Items[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_MetadataType getCh_St_Bapi_Metadata() {
        return (com.kcdata.abe.bapi.Yst_MetadataType)baseTypeData().getElementValue(0);
    }

    public void setIt_Veh_Items(com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List It_Veh_Items) {
        baseTypeData().setElementValue(3, It_Veh_Items);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Veh_ItemsType[] getIt_Veh_Items() {
        com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Veh_ItemsType();
    }

    public void setIt_Guestinfo(com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List It_Guestinfo) {
        baseTypeData().setElementValue(10, It_Guestinfo);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Ota_Retrieve_Quote_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Ota_Retrieve_Quote_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Flt_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(12);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ins_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Pax_Pricing() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Flt_Segments() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(11);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_St_Quotesearch() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Guestinfo() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(10);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ser_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Application_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Charges() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(13);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Roomstaycandidates() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCh_St_Bapi_Metadata() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Veh_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
    }

}
