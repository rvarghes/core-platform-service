package com.kcdata.abe.bapi;
public class Z_Api_Resort_List_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1245945380218L) ;

    private  Z_Api_Resort_List_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_RESORT_LIST.Input", 4, 0, com.kcdata.abe.bapi.Z_Api_Resort_List_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_RESORT_LIST", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">List possible resorts destination wise</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "DESITNATION", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Desitnation", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "DESITNATION", 0, 0, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"DESITNATION\"><ifr:descriptor /><ifr:definition><ifr:field name=\"ZSROMSL.ZZDESTN_V\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>6</ifr:offset1><ifr:offset2>12</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"ZZDESTN\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "RESORT_AREA", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Resort_Area", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "RESORT_AREA", 0, 0, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"RESORT_AREA\"><ifr:descriptor /><ifr:definition><ifr:field name=\"ZSROMSL.ZZRESORT_V\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>39</ifr:offset1><ifr:offset2>78</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"ZZRESORT_V\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "RESORTS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Resorts", com.kcdata.abe.bapi.util.ZshcharType_List.class, new com.kcdata.abe.bapi.ZshcharType(), new java.lang.String[][]{}, "RESORTS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"RESORTS\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZSHCHAR\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZSHCHAR\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "HOTELS_NAME", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Hotels_Name", com.kcdata.abe.bapi.util.ZshcharType_List.class, new com.kcdata.abe.bapi.ZshcharType(), new java.lang.String[][]{}, "HOTELS_NAME", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"HOTELS_NAME\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZSHCHAR\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZSHCHAR\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Z_Api_Resort_List_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Z_Api_Resort_List_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setResort_Area(java.lang.String Resort_Area) {
        baseTypeData().setElementValue(1, Resort_Area);
    }

    public void setDesitnation(java.lang.String Desitnation) {
        baseTypeData().setElementValue(0, Desitnation);
    }

    public void setHotels_Name(com.kcdata.abe.bapi.ZshcharType[] Hotels_Name) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.ZshcharType_List());
        com.kcdata.abe.bapi.util.ZshcharType_List list$ = get_as_listHotels_Name();
        for (int  i$ = 0; i$ < Hotels_Name.length; i$++){
         list$.addZshcharType(Hotels_Name[ i$]);
        }
    }

    public void setResorts(com.kcdata.abe.bapi.util.ZshcharType_List Resorts) {
        baseTypeData().setElementValue(2, Resorts);
    }

    public void setHotels_Name(com.kcdata.abe.bapi.util.ZshcharType_List Hotels_Name) {
        baseTypeData().setElementValue(3, Hotels_Name);
    }

    public MetaData metadataZ_Api_Resort_List_Input() {
        return metadata;
    }

    public java.lang.String getDesitnation() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public com.kcdata.abe.bapi.util.ZshcharType_List get_as_listResorts() {
        return (com.kcdata.abe.bapi.util.ZshcharType_List)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.ZshcharType[] getHotels_Name() {
        com.kcdata.abe.bapi.util.ZshcharType_List i$ = (com.kcdata.abe.bapi.util.ZshcharType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayZshcharType();
    }

    public java.lang.String getResort_Area() {
        return (java.lang.String)baseTypeData().getElementValueAsString(1);
    }

    public com.kcdata.abe.bapi.ZshcharType[] getResorts() {
        com.kcdata.abe.bapi.util.ZshcharType_List i$ = (com.kcdata.abe.bapi.util.ZshcharType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayZshcharType();
    }

    public void setResorts(com.kcdata.abe.bapi.ZshcharType[] Resorts) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.ZshcharType_List());
        com.kcdata.abe.bapi.util.ZshcharType_List list$ = get_as_listResorts();
        for (int  i$ = 0; i$ < Resorts.length; i$++){
         list$.addZshcharType(Resorts[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.ZshcharType_List get_as_listHotels_Name() {
        return (com.kcdata.abe.bapi.util.ZshcharType_List)baseTypeData().getElementValue(3);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Resort_List_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Resort_List_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getResort_Area() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getResorts() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getHotels_Name() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getDesitnation() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
