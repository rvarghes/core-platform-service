package com.kcdata.abe.bapi;
public class Z_Api_Send_Mail_Itin_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1318915570252L) ;

    private  Z_Api_Send_Mail_Itin_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_SEND_MAIL_ITIN.Output", 2, 0, com.kcdata.abe.bapi.Z_Api_Send_Mail_Itin_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_SEND_MAIL_ITIN", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Send Feed to Epsilon from ITIN Viewer</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "RETURN", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRETURN", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Return", com.kcdata.abe.bapi.BapireturnType.class, new com.kcdata.abe.bapi.BapireturnType(), new java.lang.String[][]{}, "RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRETURN\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRETURN\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_EPSILON_CC_INFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Epsilon_Cc_Info", com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List.class, new com.kcdata.abe.bapi.Zepsilon_Cc_FeedType(), new java.lang.String[][]{}, "IT_EPSILON_CC_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_EPSILON_CC_INFO\"><ifr:descriptor><ifr:description language=\"EN\">Epsilon Credit Card Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZEPSILON_CC_FEED\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZEPSILON_CC_FEED\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Z_Api_Send_Mail_Itin_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Z_Api_Send_Mail_Itin_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public com.kcdata.abe.bapi.Zepsilon_Cc_FeedType[] getIt_Epsilon_Cc_Info() {
        com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List i$ = (com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZepsilon_Cc_FeedType();
    }

    public MetaData metadataZ_Api_Send_Mail_Itin_Output() {
        return metadata;
    }

    public com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List get_as_listIt_Epsilon_Cc_Info() {
        return (com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List)baseTypeData().getElementValue(1);
    }

    public com.kcdata.abe.bapi.BapireturnType getReturn() {
        return (com.kcdata.abe.bapi.BapireturnType)baseTypeData().getElementValue(0);
    }

    public void setReturn(com.kcdata.abe.bapi.BapireturnType Return) {
        baseTypeData().setElementValue(0, Return);
    }

    public void setIt_Epsilon_Cc_Info(com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List It_Epsilon_Cc_Info) {
        baseTypeData().setElementValue(1, It_Epsilon_Cc_Info);
    }

    public void setIt_Epsilon_Cc_Info(com.kcdata.abe.bapi.Zepsilon_Cc_FeedType[] It_Epsilon_Cc_Info) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List());
        com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List list$ = get_as_listIt_Epsilon_Cc_Info();
        for (int  i$ = 0; i$ < It_Epsilon_Cc_Info.length; i$++){
         list$.addZepsilon_Cc_FeedType(It_Epsilon_Cc_Info[ i$]);
        }
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Send_Mail_Itin_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Send_Mail_Itin_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Epsilon_Cc_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getReturn() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
