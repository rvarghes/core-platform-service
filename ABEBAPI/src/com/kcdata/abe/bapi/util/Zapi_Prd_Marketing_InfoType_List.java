package com.kcdata.abe.bapi.util;
public class Zapi_Prd_Marketing_InfoType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1756374973L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_PRD_MARKETING_INFO", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType.class, new com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType(), new java.lang.String[][]{}, 100, 200, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_PRD_MARKETING_INFO\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Marketing Strategy Information</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>100</ifr:internalLength1><ifr:internalLength2>200</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Prd_Marketing_InfoType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addAllZapi_Prd_Marketing_InfoType(Zapi_Prd_Marketing_InfoType_List item) {
        baseList().addAll(item);
    }

    public boolean removeZapi_Prd_Marketing_InfoType(com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType item) {
        return baseList().remove(item);
    }

    public int indexOfZapi_Prd_Marketing_InfoType(com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType getZapi_Prd_Marketing_InfoType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType)baseList().get(index);
    }

    public int lastIndexOfZapi_Prd_Marketing_InfoType(com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType item) {
        return baseList().lastIndexOf(item);
    }

    public Zapi_Prd_Marketing_InfoType_List subListZapi_Prd_Marketing_InfoType(int fromIndex, int toIndex) {
        return (Zapi_Prd_Marketing_InfoType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean containsAllZapi_Prd_Marketing_InfoType(Zapi_Prd_Marketing_InfoType_List item) {
        return baseList().containsAll(item);
    }

    public void addAllZapi_Prd_Marketing_InfoType(int index, Zapi_Prd_Marketing_InfoType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType[] toArrayZapi_Prd_Marketing_InfoType() {
        return (com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType[] {});
    }

    public void addZapi_Prd_Marketing_InfoType(com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType item) {
        baseList().add(item);
    }

    public boolean containsZapi_Prd_Marketing_InfoType(com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType item) {
        return baseList().contains(item);
    }

    public void addZapi_Prd_Marketing_InfoType(int index, com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType setZapi_Prd_Marketing_InfoType(int index, com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType item) {
        return (com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType)baseList().set(index, item);
    }

    public com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType removeZapi_Prd_Marketing_InfoType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType)baseList().remove(index);
    }

}
