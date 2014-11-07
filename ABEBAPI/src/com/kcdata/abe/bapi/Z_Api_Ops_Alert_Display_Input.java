package com.kcdata.abe.bapi;
public class Z_Api_Ops_Alert_Display_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1257710242390L) ;

    private  Z_Api_Ops_Alert_Display_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_OPS_ALERT_DISPLAY.Input", 2, 0, com.kcdata.abe.bapi.Z_Api_Ops_Alert_Display_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_OPS_ALERT_DISPLAY", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Function Moulde to Diplay OPS alert from Comments screen</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "ZALERT_ID", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Zalert_Id", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "10"}}, "ZALERT_ID", 0, 0, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_NUM, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"ZALERT_ID\"><ifr:descriptor /><ifr:definition><ifr:field name=\"ZALERT_HD.ZZALERT_ID\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>3</ifr:offset1><ifr:offset2>6</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"ZALID\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "ZALERTIT", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Zalertit", com.kcdata.abe.bapi.util.Zalert_ItType_List.class, new com.kcdata.abe.bapi.Zalert_ItType(), new java.lang.String[][]{}, "ZALERTIT", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"ZALERTIT\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZALERT_IT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZALERT_IT\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Z_Api_Ops_Alert_Display_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Z_Api_Ops_Alert_Display_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public com.kcdata.abe.bapi.Zalert_ItType[] getZalertit() {
        com.kcdata.abe.bapi.util.Zalert_ItType_List i$ = (com.kcdata.abe.bapi.util.Zalert_ItType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZalert_ItType();
    }

    public java.lang.String getZalert_Id() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public void setZalert_Id(java.lang.String Zalert_Id) {
        baseTypeData().setElementValue(0, Zalert_Id);
    }

    public MetaData metadataZ_Api_Ops_Alert_Display_Input() {
        return metadata;
    }

    public void setZalertit(com.kcdata.abe.bapi.util.Zalert_ItType_List Zalertit) {
        baseTypeData().setElementValue(1, Zalertit);
    }

    public void setZalertit(com.kcdata.abe.bapi.Zalert_ItType[] Zalertit) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Zalert_ItType_List());
        com.kcdata.abe.bapi.util.Zalert_ItType_List list$ = get_as_listZalertit();
        for (int  i$ = 0; i$ < Zalertit.length; i$++){
         list$.addZalert_ItType(Zalertit[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Zalert_ItType_List get_as_listZalertit() {
        return (com.kcdata.abe.bapi.util.Zalert_ItType_List)baseTypeData().getElementValue(1);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Ops_Alert_Display_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Ops_Alert_Display_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZalertit() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getZalert_Id() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
    }

}
