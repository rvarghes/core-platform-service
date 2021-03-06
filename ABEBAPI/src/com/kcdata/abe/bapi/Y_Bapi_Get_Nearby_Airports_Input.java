package com.kcdata.abe.bapi;
public class Y_Bapi_Get_Nearby_Airports_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1317392173014L) ;

    private  Y_Bapi_Get_Nearby_Airports_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_GET_NEARBY_AIRPORTS.Input", 6, 0, com.kcdata.abe.bapi.Y_Bapi_Get_Nearby_Airports_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_GET_NEARBY_AIRPORTS", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">test</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "IM_APPLICATION_INFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_APPLI_INFO", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Application_Info", com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType.class, new com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType(), new java.lang.String[][]{}, "IM_APPLICATION_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_APPLICATION_INFO\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Application Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_APPLI_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_APPLI_INFO\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IM_GATE_DEST", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Gate_Dest", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "IM_GATE_DEST", 0, 0, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_GATE_DEST\"><ifr:descriptor><ifr:description language=\"EN\">IATA location</ifr:description></ifr:descriptor><ifr:definition><ifr:scalarType name=\"IATA_LOCATION\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IM_MILES", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:short", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Miles", java.lang.Short.class, null, new java.lang.String[][]{}, "IM_MILES", 0, 0, -1, 2, 2, -1, com.sap.mw.jco.JCO.TYPE_INT2, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_MILES\"><ifr:descriptor><ifr:description language=\"EN\">Miles</ifr:description></ifr:descriptor><ifr:definition><ifr:scalarType name=\"YYMILES\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>INT2</ifr:type><ifr:abapType>s</ifr:abapType><ifr:length>5</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>6</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IM_TYPE_GD", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Type_Gd", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "IM_TYPE_GD", 0, 0, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_TYPE_GD\"><ifr:descriptor><ifr:description language=\"EN\">Single-Character Indicator</ifr:description></ifr:descriptor><ifr:definition><ifr:scalarType name=\"CHAR1\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "TI_YNEARBY_AIRPORT", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Ti_Ynearby_Airport", com.kcdata.abe.bapi.util.Ynearby_AirportType_List.class, new com.kcdata.abe.bapi.Ynearby_AirportType(), new java.lang.String[][]{}, "TI_YNEARBY_AIRPORT", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"TI_YNEARBY_AIRPORT\"><ifr:descriptor><ifr:description language=\"EN\">Gateway Destination Near by Airport Codes</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YNEARBY_AIRPORT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YNEARBY_AIRPORT\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Bapi_Get_Nearby_Airports_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Bapi_Get_Nearby_Airports_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setTi_Ynearby_Airport(com.kcdata.abe.bapi.util.Ynearby_AirportType_List Ti_Ynearby_Airport) {
        baseTypeData().setElementValue(4, Ti_Ynearby_Airport);
    }

    public short getIm_Miles() {
        return baseTypeData().getElementValueAsShort(2);
    }

    public MetaData metadataY_Bapi_Get_Nearby_Airports_Input() {
        return metadata;
    }

    public void setIm_Gate_Dest(java.lang.String Im_Gate_Dest) {
        baseTypeData().setElementValue(1, Im_Gate_Dest);
    }

    public void setIm_Miles(short Im_Miles) {
        baseTypeData().setElementValue(2, Im_Miles);
    }

    public java.lang.String getIm_Gate_Dest() {
        return (java.lang.String)baseTypeData().getElementValueAsString(1);
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(5, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Ynearby_AirportType[] getTi_Ynearby_Airport() {
        com.kcdata.abe.bapi.util.Ynearby_AirportType_List i$ = (com.kcdata.abe.bapi.util.Ynearby_AirportType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayYnearby_AirportType();
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(5);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(5, It_Return);
    }

    public void setTi_Ynearby_Airport(com.kcdata.abe.bapi.Ynearby_AirportType[] Ti_Ynearby_Airport) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Ynearby_AirportType_List());
        com.kcdata.abe.bapi.util.Ynearby_AirportType_List list$ = get_as_listTi_Ynearby_Airport();
        for (int  i$ = 0; i$ < Ti_Ynearby_Airport.length; i$++){
         list$.addYnearby_AirportType(Ti_Ynearby_Airport[ i$]);
        }
    }

    public void setIm_Type_Gd(java.lang.String Im_Type_Gd) {
        baseTypeData().setElementValue(3, Im_Type_Gd);
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(5);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType getIm_Application_Info() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType)baseTypeData().getElementValue(0);
    }

    public void setIm_Application_Info(com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType Im_Application_Info) {
        baseTypeData().setElementValue(0, Im_Application_Info);
    }

    public java.lang.String getIm_Type_Gd() {
        return (java.lang.String)baseTypeData().getElementValueAsString(3);
    }

    public com.kcdata.abe.bapi.util.Ynearby_AirportType_List get_as_listTi_Ynearby_Airport() {
        return (com.kcdata.abe.bapi.util.Ynearby_AirportType_List)baseTypeData().getElementValue(4);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Get_Nearby_Airports_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Get_Nearby_Airports_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Miles() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Application_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Gate_Dest() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getTi_Ynearby_Airport() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Type_Gd() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
    }

}
