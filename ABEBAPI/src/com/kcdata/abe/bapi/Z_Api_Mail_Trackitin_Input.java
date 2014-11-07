package com.kcdata.abe.bapi;
public class Z_Api_Mail_Trackitin_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1318915552078L) ;

    private  Z_Api_Mail_Trackitin_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_MAIL_TRACKITIN.Input", 5, 0, com.kcdata.abe.bapi.Z_Api_Mail_Trackitin_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_MAIL_TRACKITIN", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">E-mail tracking process</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "PASS_DETAILS", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZTRACKITIN_PAX", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Pass_Details", com.kcdata.abe.bapi.Ztrackitin_PaxType.class, new com.kcdata.abe.bapi.Ztrackitin_PaxType(), new java.lang.String[][]{}, "PASS_DETAILS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"PASS_DETAILS\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZTRACKITIN_PAX\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZTRACKITIN_PAX\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "TA_DETAILS", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZTRACKITIN_TA", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Ta_Details", com.kcdata.abe.bapi.Ztrackitin_TaType.class, new com.kcdata.abe.bapi.Ztrackitin_TaType(), new java.lang.String[][]{}, "TA_DETAILS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"TA_DETAILS\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZTRACKITIN_TA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZTRACKITIN_TA\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "UPDATE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Update", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "UPDATE", 0, 0, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"UPDATE\"><ifr:descriptor><ifr:description language=\"EN\">Update flage (Value &apos;X&apos; for update)</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"ZREM.UPDATE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>31</ifr:offset1><ifr:offset2>62</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"ZUPDATE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "TA_AGENT", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Ta_Agent", com.kcdata.abe.bapi.util.Ztrackitin_TaType_List.class, new com.kcdata.abe.bapi.Ztrackitin_TaType(), new java.lang.String[][]{}, "TA_AGENT", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"TA_AGENT\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZTRACKITIN_TA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZTRACKITIN_TA\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "PASSENGERS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Passengers", com.kcdata.abe.bapi.util.Ztrackitin_PaxType_List.class, new com.kcdata.abe.bapi.Ztrackitin_PaxType(), new java.lang.String[][]{}, "PASSENGERS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"PASSENGERS\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZTRACKITIN_PAX\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZTRACKITIN_PAX\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Z_Api_Mail_Trackitin_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Z_Api_Mail_Trackitin_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public MetaData metadataZ_Api_Mail_Trackitin_Input() {
        return metadata;
    }

    public com.kcdata.abe.bapi.util.Ztrackitin_TaType_List get_as_listTa_Agent() {
        return (com.kcdata.abe.bapi.util.Ztrackitin_TaType_List)baseTypeData().getElementValue(3);
    }

    public com.kcdata.abe.bapi.Ztrackitin_PaxType[] getPassengers() {
        com.kcdata.abe.bapi.util.Ztrackitin_PaxType_List i$ = (com.kcdata.abe.bapi.util.Ztrackitin_PaxType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayZtrackitin_PaxType();
    }

    public com.kcdata.abe.bapi.Ztrackitin_PaxType getPass_Details() {
        return (com.kcdata.abe.bapi.Ztrackitin_PaxType)baseTypeData().getElementValue(0);
    }

    public void setTa_Details(com.kcdata.abe.bapi.Ztrackitin_TaType Ta_Details) {
        baseTypeData().setElementValue(1, Ta_Details);
    }

    public void setPassengers(com.kcdata.abe.bapi.Ztrackitin_PaxType[] Passengers) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Ztrackitin_PaxType_List());
        com.kcdata.abe.bapi.util.Ztrackitin_PaxType_List list$ = get_as_listPassengers();
        for (int  i$ = 0; i$ < Passengers.length; i$++){
         list$.addZtrackitin_PaxType(Passengers[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Ztrackitin_TaType[] getTa_Agent() {
        com.kcdata.abe.bapi.util.Ztrackitin_TaType_List i$ = (com.kcdata.abe.bapi.util.Ztrackitin_TaType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayZtrackitin_TaType();
    }

    public void setTa_Agent(com.kcdata.abe.bapi.util.Ztrackitin_TaType_List Ta_Agent) {
        baseTypeData().setElementValue(3, Ta_Agent);
    }

    public void setPass_Details(com.kcdata.abe.bapi.Ztrackitin_PaxType Pass_Details) {
        baseTypeData().setElementValue(0, Pass_Details);
    }

    public com.kcdata.abe.bapi.Ztrackitin_TaType getTa_Details() {
        return (com.kcdata.abe.bapi.Ztrackitin_TaType)baseTypeData().getElementValue(1);
    }

    public void setUpdate(java.lang.String Update) {
        baseTypeData().setElementValue(2, Update);
    }

    public void setTa_Agent(com.kcdata.abe.bapi.Ztrackitin_TaType[] Ta_Agent) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Ztrackitin_TaType_List());
        com.kcdata.abe.bapi.util.Ztrackitin_TaType_List list$ = get_as_listTa_Agent();
        for (int  i$ = 0; i$ < Ta_Agent.length; i$++){
         list$.addZtrackitin_TaType(Ta_Agent[ i$]);
        }
    }

    public void setPassengers(com.kcdata.abe.bapi.util.Ztrackitin_PaxType_List Passengers) {
        baseTypeData().setElementValue(4, Passengers);
    }

    public java.lang.String getUpdate() {
        return (java.lang.String)baseTypeData().getElementValueAsString(2);
    }

    public com.kcdata.abe.bapi.util.Ztrackitin_PaxType_List get_as_listPassengers() {
        return (com.kcdata.abe.bapi.util.Ztrackitin_PaxType_List)baseTypeData().getElementValue(4);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Mail_Trackitin_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Mail_Trackitin_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPass_Details() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getTa_Agent() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getTa_Details() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPassengers() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getUpdate() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
    }

}
