package com.kcdata.abe.bapi;
public class Z_Api_Ops_Alert_Display_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1257710242390L) ;

    private  Z_Api_Ops_Alert_Display_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_OPS_ALERT_DISPLAY.Output", 3, 0, com.kcdata.abe.bapi.Z_Api_Ops_Alert_Display_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_OPS_ALERT_DISPLAY", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Function Moulde to Diplay OPS alert from Comments screen</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "RETURN", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRETURN", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Return", com.kcdata.abe.bapi.BapireturnType.class, new com.kcdata.abe.bapi.BapireturnType(), new java.lang.String[][]{}, "RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"RETURN\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"BAPIRETURN\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRETURN\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "ZALERTHD", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZALERT_HD", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Zalerthd", com.kcdata.abe.bapi.Zalert_HdType.class, new com.kcdata.abe.bapi.Zalert_HdType(), new java.lang.String[][]{}, "ZALERTHD", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"ZALERTHD\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZALERT_HD\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZALERT_HD\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "ZALERTIT", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Zalertit", com.kcdata.abe.bapi.util.Zalert_ItType_List.class, new com.kcdata.abe.bapi.Zalert_ItType(), new java.lang.String[][]{}, "ZALERTIT", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"ZALERTIT\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZALERT_IT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZALERT_IT\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Z_Api_Ops_Alert_Display_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Z_Api_Ops_Alert_Display_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Zalert_ItType[] getZalertit() {
        com.kcdata.abe.bapi.util.Zalert_ItType_List i$ = (com.kcdata.abe.bapi.util.Zalert_ItType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayZalert_ItType();
    }

    public void setReturn(com.kcdata.abe.bapi.BapireturnType Return) {
        baseTypeData().setElementValue(0, Return);
    }

    public com.kcdata.abe.bapi.BapireturnType getReturn() {
        return (com.kcdata.abe.bapi.BapireturnType)baseTypeData().getElementValue(0);
    }

    public com.kcdata.abe.bapi.Zalert_HdType getZalerthd() {
        return (com.kcdata.abe.bapi.Zalert_HdType)baseTypeData().getElementValue(1);
    }

    public MetaData metadataZ_Api_Ops_Alert_Display_Output() {
        return metadata;
    }

    public void setZalertit(com.kcdata.abe.bapi.util.Zalert_ItType_List Zalertit) {
        baseTypeData().setElementValue(2, Zalertit);
    }

    public void setZalerthd(com.kcdata.abe.bapi.Zalert_HdType Zalerthd) {
        baseTypeData().setElementValue(1, Zalerthd);
    }

    public void setZalertit(com.kcdata.abe.bapi.Zalert_ItType[] Zalertit) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Zalert_ItType_List());
        com.kcdata.abe.bapi.util.Zalert_ItType_List list$ = get_as_listZalertit();
        for (int  i$ = 0; i$ < Zalertit.length; i$++){
         list$.addZalert_ItType(Zalertit[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Zalert_ItType_List get_as_listZalertit() {
        return (com.kcdata.abe.bapi.util.Zalert_ItType_List)baseTypeData().getElementValue(2);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Ops_Alert_Display_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Ops_Alert_Display_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZalertit() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getReturn() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZalerthd() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
    }

}
