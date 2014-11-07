package com.kcdata.abe.bapi.util;
public class Zapi_Pax_Info_DetailType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 2045757541L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_PAX_INFO_DETAIL", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType.class, new com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType(), new java.lang.String[][]{}, 138, 244, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_PAX_INFO_DETAIL\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Passenger Info detail prices</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>138</ifr:internalLength1><ifr:internalLength2>244</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Pax_Info_DetailType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean removeZapi_Pax_Info_DetailType(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType item) {
        return baseList().remove(item);
    }

    public boolean containsAllZapi_Pax_Info_DetailType(Zapi_Pax_Info_DetailType_List item) {
        return baseList().containsAll(item);
    }

    public int indexOfZapi_Pax_Info_DetailType(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType getZapi_Pax_Info_DetailType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType)baseList().get(index);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType removeZapi_Pax_Info_DetailType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType)baseList().remove(index);
    }

    public void addZapi_Pax_Info_DetailType(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType item) {
        baseList().add(item);
    }

    public void addAllZapi_Pax_Info_DetailType(Zapi_Pax_Info_DetailType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType setZapi_Pax_Info_DetailType(int index, com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType item) {
        return (com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType)baseList().set(index, item);
    }

    public void addAllZapi_Pax_Info_DetailType(int index, Zapi_Pax_Info_DetailType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType[] toArrayZapi_Pax_Info_DetailType() {
        return (com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType[] {});
    }

    public int lastIndexOfZapi_Pax_Info_DetailType(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType item) {
        return baseList().lastIndexOf(item);
    }

    public void addZapi_Pax_Info_DetailType(int index, com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType item) {
        baseList().add(index, item);
    }

    public boolean containsZapi_Pax_Info_DetailType(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType item) {
        return baseList().contains(item);
    }

    public Zapi_Pax_Info_DetailType_List subListZapi_Pax_Info_DetailType(int fromIndex, int toIndex) {
        return (Zapi_Pax_Info_DetailType_List)baseList().subList(fromIndex, toIndex);
    }

}
