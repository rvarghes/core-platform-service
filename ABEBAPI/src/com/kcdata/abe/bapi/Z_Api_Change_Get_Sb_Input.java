package com.kcdata.abe.bapi;
public class Z_Api_Change_Get_Sb_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1321529460412L) ;

    private  Z_Api_Change_Get_Sb_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_CHANGE_GET_SB.Input", 7, 0, com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_CHANGE_GET_SB", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Get all the contents of the shopping basket</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "BOOKINGNO", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Bookingno", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "BOOKINGNO", 0, 0, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"BOOKINGNO\"><ifr:descriptor /><ifr:definition><ifr:field name=\"VBAK.VBELN\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:checkTable>VBUK</ifr:checkTable><ifr:offset1>3</ifr:offset1><ifr:offset2>6</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"VBELN_VA\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength><ifr:conversionExit>ALPHA</ifr:conversionExit></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "R_IT_ZISSPI", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "R_It_Zisspi", com.kcdata.abe.bapi.util.ZisspiType_List.class, new com.kcdata.abe.bapi.ZisspiType(), new java.lang.String[][]{}, "R_IT_ZISSPI", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"R_IT_ZISSPI\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZISSPI\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZISSPI\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "R_IT_SHOPBK", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "R_It_Shopbk", com.kcdata.abe.bapi.util.Zsshpbk1Type_List.class, new com.kcdata.abe.bapi.Zsshpbk1Type(), new java.lang.String[][]{}, "R_IT_SHOPBK", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"R_IT_SHOPBK\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZSSHPBK1\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZSSHPBK1\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "R_IT_RFA_V_CON", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "R_It_Rfa_V_Con", com.kcdata.abe.bapi.util.ZfbrmdType_List.class, new com.kcdata.abe.bapi.ZfbrmdType(), new java.lang.String[][]{}, "R_IT_RFA_V_CON", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"R_IT_RFA_V_CON\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZFBRMD\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZFBRMD\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "R_IT_PAXPRICE", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "R_It_Paxprice", com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailsType_List.class, new com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType(), new java.lang.String[][]{}, "R_IT_PAXPRICE", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"R_IT_PAXPRICE\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZAPI_PAX_INFO_DETAILS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_PAX_INFO_DETAILS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "R_IT_MATRECAP", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "R_It_Matrecap", com.kcdata.abe.bapi.util.ZmatrecapType_List.class, new com.kcdata.abe.bapi.ZmatrecapType(), new java.lang.String[][]{}, "R_IT_MATRECAP", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"R_IT_MATRECAP\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZMATRECAP\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZMATRECAP\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 6, "IT_ZCARG", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Zcarg", com.kcdata.abe.bapi.util.ZcargType_List.class, new com.kcdata.abe.bapi.ZcargType(), new java.lang.String[][]{}, "IT_ZCARG", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_ZCARG\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZCARG\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZCARG\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Z_Api_Change_Get_Sb_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Z_Api_Change_Get_Sb_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public MetaData metadataZ_Api_Change_Get_Sb_Input() {
        return metadata;
    }

    public com.kcdata.abe.bapi.ZisspiType[] getR_It_Zisspi() {
        com.kcdata.abe.bapi.util.ZisspiType_List i$ = (com.kcdata.abe.bapi.util.ZisspiType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZisspiType();
    }

    public com.kcdata.abe.bapi.ZfbrmdType[] getR_It_Rfa_V_Con() {
        com.kcdata.abe.bapi.util.ZfbrmdType_List i$ = (com.kcdata.abe.bapi.util.ZfbrmdType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayZfbrmdType();
    }

    public void setR_It_Shopbk(com.kcdata.abe.bapi.Zsshpbk1Type[] R_It_Shopbk) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Zsshpbk1Type_List());
        com.kcdata.abe.bapi.util.Zsshpbk1Type_List list$ = get_as_listR_It_Shopbk();
        for (int  i$ = 0; i$ < R_It_Shopbk.length; i$++){
         list$.addZsshpbk1Type(R_It_Shopbk[ i$]);
        }
    }

    public void setBookingno(java.lang.String Bookingno) {
        baseTypeData().setElementValue(0, Bookingno);
    }

    public void setR_It_Paxprice(com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailsType_List R_It_Paxprice) {
        baseTypeData().setElementValue(4, R_It_Paxprice);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType[] getR_It_Paxprice() {
        com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailsType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailsType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Pax_Info_DetailsType();
    }

    public void setR_It_Rfa_V_Con(com.kcdata.abe.bapi.util.ZfbrmdType_List R_It_Rfa_V_Con) {
        baseTypeData().setElementValue(3, R_It_Rfa_V_Con);
    }

    public void setR_It_Zisspi(com.kcdata.abe.bapi.util.ZisspiType_List R_It_Zisspi) {
        baseTypeData().setElementValue(1, R_It_Zisspi);
    }

    public com.kcdata.abe.bapi.ZmatrecapType[] getR_It_Matrecap() {
        com.kcdata.abe.bapi.util.ZmatrecapType_List i$ = (com.kcdata.abe.bapi.util.ZmatrecapType_List)baseTypeData().getElementValue(5);
        if ( i$ == null){return null;}
        return  i$.toArrayZmatrecapType();
    }

    public com.kcdata.abe.bapi.ZcargType[] getIt_Zcarg() {
        com.kcdata.abe.bapi.util.ZcargType_List i$ = (com.kcdata.abe.bapi.util.ZcargType_List)baseTypeData().getElementValue(6);
        if ( i$ == null){return null;}
        return  i$.toArrayZcargType();
    }

    public com.kcdata.abe.bapi.util.ZisspiType_List get_as_listR_It_Zisspi() {
        return (com.kcdata.abe.bapi.util.ZisspiType_List)baseTypeData().getElementValue(1);
    }

    public com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailsType_List get_as_listR_It_Paxprice() {
        return (com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailsType_List)baseTypeData().getElementValue(4);
    }

    public void setR_It_Matrecap(com.kcdata.abe.bapi.util.ZmatrecapType_List R_It_Matrecap) {
        baseTypeData().setElementValue(5, R_It_Matrecap);
    }

    public void setR_It_Shopbk(com.kcdata.abe.bapi.util.Zsshpbk1Type_List R_It_Shopbk) {
        baseTypeData().setElementValue(2, R_It_Shopbk);
    }

    public java.lang.String getBookingno() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public com.kcdata.abe.bapi.util.ZmatrecapType_List get_as_listR_It_Matrecap() {
        return (com.kcdata.abe.bapi.util.ZmatrecapType_List)baseTypeData().getElementValue(5);
    }

    public void setIt_Zcarg(com.kcdata.abe.bapi.util.ZcargType_List It_Zcarg) {
        baseTypeData().setElementValue(6, It_Zcarg);
    }

    public void setIt_Zcarg(com.kcdata.abe.bapi.ZcargType[] It_Zcarg) {
        baseTypeData().setElementValue(6, new com.kcdata.abe.bapi.util.ZcargType_List());
        com.kcdata.abe.bapi.util.ZcargType_List list$ = get_as_listIt_Zcarg();
        for (int  i$ = 0; i$ < It_Zcarg.length; i$++){
         list$.addZcargType(It_Zcarg[ i$]);
        }
    }

    public void setR_It_Paxprice(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType[] R_It_Paxprice) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailsType_List());
        com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailsType_List list$ = get_as_listR_It_Paxprice();
        for (int  i$ = 0; i$ < R_It_Paxprice.length; i$++){
         list$.addZapi_Pax_Info_DetailsType(R_It_Paxprice[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Zsshpbk1Type[] getR_It_Shopbk() {
        com.kcdata.abe.bapi.util.Zsshpbk1Type_List i$ = (com.kcdata.abe.bapi.util.Zsshpbk1Type_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayZsshpbk1Type();
    }

    public void setR_It_Matrecap(com.kcdata.abe.bapi.ZmatrecapType[] R_It_Matrecap) {
        baseTypeData().setElementValue(5, new com.kcdata.abe.bapi.util.ZmatrecapType_List());
        com.kcdata.abe.bapi.util.ZmatrecapType_List list$ = get_as_listR_It_Matrecap();
        for (int  i$ = 0; i$ < R_It_Matrecap.length; i$++){
         list$.addZmatrecapType(R_It_Matrecap[ i$]);
        }
    }

    public void setR_It_Rfa_V_Con(com.kcdata.abe.bapi.ZfbrmdType[] R_It_Rfa_V_Con) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.ZfbrmdType_List());
        com.kcdata.abe.bapi.util.ZfbrmdType_List list$ = get_as_listR_It_Rfa_V_Con();
        for (int  i$ = 0; i$ < R_It_Rfa_V_Con.length; i$++){
         list$.addZfbrmdType(R_It_Rfa_V_Con[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Zsshpbk1Type_List get_as_listR_It_Shopbk() {
        return (com.kcdata.abe.bapi.util.Zsshpbk1Type_List)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.util.ZfbrmdType_List get_as_listR_It_Rfa_V_Con() {
        return (com.kcdata.abe.bapi.util.ZfbrmdType_List)baseTypeData().getElementValue(3);
    }

    public void setR_It_Zisspi(com.kcdata.abe.bapi.ZisspiType[] R_It_Zisspi) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.ZisspiType_List());
        com.kcdata.abe.bapi.util.ZisspiType_List list$ = get_as_listR_It_Zisspi();
        for (int  i$ = 0; i$ < R_It_Zisspi.length; i$++){
         list$.addZisspiType(R_It_Zisspi[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.ZcargType_List get_as_listIt_Zcarg() {
        return (com.kcdata.abe.bapi.util.ZcargType_List)baseTypeData().getElementValue(6);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Change_Get_Sb_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Change_Get_Sb_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getR_It_Zisspi() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getR_It_Rfa_V_Con() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getBookingno() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getR_It_Paxprice() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getR_It_Matrecap() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getR_It_Shopbk() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Zcarg() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
    }

}
