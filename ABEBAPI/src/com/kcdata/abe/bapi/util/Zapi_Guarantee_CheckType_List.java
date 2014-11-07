package com.kcdata.abe.bapi.util;
public class Zapi_Guarantee_CheckType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1099404308L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_GUARANTEE_CHECK", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Guarantee_CheckType.class, new com.kcdata.abe.bapi.Zapi_Guarantee_CheckType(), new java.lang.String[][]{}, 53, 98, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_GUARANTEE_CHECK\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Guarantee Check</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>53</ifr:internalLength1><ifr:internalLength2>98</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Guarantee_CheckType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addZapi_Guarantee_CheckType(int index, com.kcdata.abe.bapi.Zapi_Guarantee_CheckType item) {
        baseList().add(index, item);
    }

    public boolean containsAllZapi_Guarantee_CheckType(Zapi_Guarantee_CheckType_List item) {
        return baseList().containsAll(item);
    }

    public int indexOfZapi_Guarantee_CheckType(com.kcdata.abe.bapi.Zapi_Guarantee_CheckType item) {
        return baseList().indexOf(item);
    }

    public int lastIndexOfZapi_Guarantee_CheckType(com.kcdata.abe.bapi.Zapi_Guarantee_CheckType item) {
        return baseList().lastIndexOf(item);
    }

    public boolean removeZapi_Guarantee_CheckType(com.kcdata.abe.bapi.Zapi_Guarantee_CheckType item) {
        return baseList().remove(item);
    }

    public com.kcdata.abe.bapi.Zapi_Guarantee_CheckType setZapi_Guarantee_CheckType(int index, com.kcdata.abe.bapi.Zapi_Guarantee_CheckType item) {
        return (com.kcdata.abe.bapi.Zapi_Guarantee_CheckType)baseList().set(index, item);
    }

    public void addAllZapi_Guarantee_CheckType(Zapi_Guarantee_CheckType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Zapi_Guarantee_CheckType[] toArrayZapi_Guarantee_CheckType() {
        return (com.kcdata.abe.bapi.Zapi_Guarantee_CheckType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Guarantee_CheckType[] {});
    }

    public void addAllZapi_Guarantee_CheckType(int index, Zapi_Guarantee_CheckType_List item) {
        baseList().addAll(index, item);
    }

    public void addZapi_Guarantee_CheckType(com.kcdata.abe.bapi.Zapi_Guarantee_CheckType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Zapi_Guarantee_CheckType removeZapi_Guarantee_CheckType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Guarantee_CheckType)baseList().remove(index);
    }

    public boolean containsZapi_Guarantee_CheckType(com.kcdata.abe.bapi.Zapi_Guarantee_CheckType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Zapi_Guarantee_CheckType getZapi_Guarantee_CheckType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Guarantee_CheckType)baseList().get(index);
    }

    public Zapi_Guarantee_CheckType_List subListZapi_Guarantee_CheckType(int fromIndex, int toIndex) {
        return (Zapi_Guarantee_CheckType_List)baseList().subList(fromIndex, toIndex);
    }

}
