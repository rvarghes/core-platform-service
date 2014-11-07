package com.kcdata.abe.bapi.util;
public class Zapi_Pax_InfoType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1291445185L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_PAX_INFO", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Pax_InfoType.class, new com.kcdata.abe.bapi.Zapi_Pax_InfoType(), new java.lang.String[][]{}, 130, 204, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_PAX_INFO\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Passenger Info Header prices</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>130</ifr:internalLength1><ifr:internalLength2>204</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Pax_InfoType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsZapi_Pax_InfoType(com.kcdata.abe.bapi.Zapi_Pax_InfoType item) {
        return baseList().contains(item);
    }

    public void addAllZapi_Pax_InfoType(Zapi_Pax_InfoType_List item) {
        baseList().addAll(item);
    }

    public void addZapi_Pax_InfoType(com.kcdata.abe.bapi.Zapi_Pax_InfoType item) {
        baseList().add(item);
    }

    public void addAllZapi_Pax_InfoType(int index, Zapi_Pax_InfoType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_InfoType removeZapi_Pax_InfoType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Pax_InfoType)baseList().remove(index);
    }

    public void addZapi_Pax_InfoType(int index, com.kcdata.abe.bapi.Zapi_Pax_InfoType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_InfoType getZapi_Pax_InfoType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Pax_InfoType)baseList().get(index);
    }

    public int indexOfZapi_Pax_InfoType(com.kcdata.abe.bapi.Zapi_Pax_InfoType item) {
        return baseList().indexOf(item);
    }

    public boolean containsAllZapi_Pax_InfoType(Zapi_Pax_InfoType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_InfoType setZapi_Pax_InfoType(int index, com.kcdata.abe.bapi.Zapi_Pax_InfoType item) {
        return (com.kcdata.abe.bapi.Zapi_Pax_InfoType)baseList().set(index, item);
    }

    public int lastIndexOfZapi_Pax_InfoType(com.kcdata.abe.bapi.Zapi_Pax_InfoType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_InfoType[] toArrayZapi_Pax_InfoType() {
        return (com.kcdata.abe.bapi.Zapi_Pax_InfoType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Pax_InfoType[] {});
    }

    public boolean removeZapi_Pax_InfoType(com.kcdata.abe.bapi.Zapi_Pax_InfoType item) {
        return baseList().remove(item);
    }

    public Zapi_Pax_InfoType_List subListZapi_Pax_InfoType(int fromIndex, int toIndex) {
        return (Zapi_Pax_InfoType_List)baseList().subList(fromIndex, toIndex);
    }

}
