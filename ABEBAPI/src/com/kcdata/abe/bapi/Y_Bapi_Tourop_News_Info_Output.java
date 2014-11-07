package com.kcdata.abe.bapi;
public class Y_Bapi_Tourop_News_Info_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1271359122062L) ;

    private  Y_Bapi_Tourop_News_Info_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_TOUROP_NEWS_INFO.Output", 3, 0, com.kcdata.abe.bapi.Y_Bapi_Tourop_News_Info_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_TOUROP_NEWS_INFO", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Retrieve News</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "IT_TOUR_NEWS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Tour_News", com.kcdata.abe.bapi.util.Yst_NewsType_List.class, new com.kcdata.abe.bapi.Yst_NewsType(), new java.lang.String[][]{}, "IT_TOUR_NEWS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_TOUR_NEWS\"><ifr:descriptor><ifr:description language=\"EN\">Tour Operation News and Message</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_NEWS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_NEWS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IT_NEWS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_News", com.kcdata.abe.bapi.util.Zapi_NewsType_List.class, new com.kcdata.abe.bapi.Zapi_NewsType(), new java.lang.String[][]{}, "IT_NEWS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_NEWS\"><ifr:descriptor><ifr:description language=\"EN\">Structure for storing News Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_NEWS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_NEWS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Y_Bapi_Tourop_News_Info_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Y_Bapi_Tourop_News_Info_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(1);
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public void setIt_News(com.kcdata.abe.bapi.Zapi_NewsType[] It_News) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Zapi_NewsType_List());
        com.kcdata.abe.bapi.util.Zapi_NewsType_List list$ = get_as_listIt_News();
        for (int  i$ = 0; i$ < It_News.length; i$++){
         list$.addZapi_NewsType(It_News[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Zapi_NewsType_List get_as_listIt_News() {
        return (com.kcdata.abe.bapi.util.Zapi_NewsType_List)baseTypeData().getElementValue(2);
    }

    public void setIt_Tour_News(com.kcdata.abe.bapi.Yst_NewsType[] It_Tour_News) {
        baseTypeData().setElementValue(0, new com.kcdata.abe.bapi.util.Yst_NewsType_List());
        com.kcdata.abe.bapi.util.Yst_NewsType_List list$ = get_as_listIt_Tour_News();
        for (int  i$ = 0; i$ < It_Tour_News.length; i$++){
         list$.addYst_NewsType(It_Tour_News[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_NewsType_List get_as_listIt_Tour_News() {
        return (com.kcdata.abe.bapi.util.Yst_NewsType_List)baseTypeData().getElementValue(0);
    }

    public MetaData metadataY_Bapi_Tourop_News_Info_Output() {
        return metadata;
    }

    public com.kcdata.abe.bapi.Zapi_NewsType[] getIt_News() {
        com.kcdata.abe.bapi.util.Zapi_NewsType_List i$ = (com.kcdata.abe.bapi.util.Zapi_NewsType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_NewsType();
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(1, It_Return);
    }

    public com.kcdata.abe.bapi.Yst_NewsType[] getIt_Tour_News() {
        com.kcdata.abe.bapi.util.Yst_NewsType_List i$ = (com.kcdata.abe.bapi.util.Yst_NewsType_List)baseTypeData().getElementValue(0);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_NewsType();
    }

    public void setIt_Tour_News(com.kcdata.abe.bapi.util.Yst_NewsType_List It_Tour_News) {
        baseTypeData().setElementValue(0, It_Tour_News);
    }

    public void setIt_News(com.kcdata.abe.bapi.util.Zapi_NewsType_List It_News) {
        baseTypeData().setElementValue(2, It_News);
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Tourop_News_Info_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Tourop_News_Info_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_News() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Tour_News() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
