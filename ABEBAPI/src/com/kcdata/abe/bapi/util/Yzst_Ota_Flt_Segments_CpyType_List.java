package com.kcdata.abe.bapi.util;
public class Yzst_Ota_Flt_Segments_CpyType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1709227736L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YZST_OTA_FLT_SEGMENTS_CPY", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType.class, new com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType(), new java.lang.String[][]{}, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YZST_T_OTA_FLT_SEGMENTS_CPY\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Table type for YZST_OTA_FLT_SEGMENTS_CPY</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>tableType</ifr:category><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition><ifr:complexType name=\"YZST_OTA_FLT_SEGMENTS_CPY\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YZST_OTA_FLT_SEGMENTS_CPY\" /></ifr:definition></ifr:container></s0:type>") ;

    public  Yzst_Ota_Flt_Segments_CpyType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType[] toArrayYzst_Ota_Flt_Segments_CpyType() {
        return (com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType[])baseList().toArray(new com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType[] {});
    }

    public int indexOfYzst_Ota_Flt_Segments_CpyType(com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType item) {
        return baseList().indexOf(item);
    }

    public void addAllYzst_Ota_Flt_Segments_CpyType(int index, Yzst_Ota_Flt_Segments_CpyType_List item) {
        baseList().addAll(index, item);
    }

    public boolean removeYzst_Ota_Flt_Segments_CpyType(com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType item) {
        return baseList().remove(item);
    }

    public void addAllYzst_Ota_Flt_Segments_CpyType(Yzst_Ota_Flt_Segments_CpyType_List item) {
        baseList().addAll(item);
    }

    public void addYzst_Ota_Flt_Segments_CpyType(com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType item) {
        baseList().add(item);
    }

    public boolean containsAllYzst_Ota_Flt_Segments_CpyType(Yzst_Ota_Flt_Segments_CpyType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType removeYzst_Ota_Flt_Segments_CpyType(int index) {
        return (com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType)baseList().remove(index);
    }

    public boolean containsYzst_Ota_Flt_Segments_CpyType(com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType setYzst_Ota_Flt_Segments_CpyType(int index, com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType item) {
        return (com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType)baseList().set(index, item);
    }

    public void addYzst_Ota_Flt_Segments_CpyType(int index, com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType item) {
        baseList().add(index, item);
    }

    public Yzst_Ota_Flt_Segments_CpyType_List subListYzst_Ota_Flt_Segments_CpyType(int fromIndex, int toIndex) {
        return (Yzst_Ota_Flt_Segments_CpyType_List)baseList().subList(fromIndex, toIndex);
    }

    public int lastIndexOfYzst_Ota_Flt_Segments_CpyType(com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType getYzst_Ota_Flt_Segments_CpyType(int index) {
        return (com.kcdata.abe.bapi.Yzst_Ota_Flt_Segments_CpyType)baseList().get(index);
    }

}
