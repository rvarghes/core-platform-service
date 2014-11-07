package com.kcdata.abe.bapi.util;
public class Zapi_ZpaxrecapType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1339221677L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_ZPAXRECAP", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_ZpaxrecapType.class, new com.kcdata.abe.bapi.Zapi_ZpaxrecapType(), new java.lang.String[][]{}, 598, 1180, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_ZPAXRECAP\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Sturcture Used to Display Pax info for OPS alerts</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>598</ifr:internalLength1><ifr:internalLength2>1180</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_ZpaxrecapType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Zapi_ZpaxrecapType[] toArrayZapi_ZpaxrecapType() {
        return (com.kcdata.abe.bapi.Zapi_ZpaxrecapType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_ZpaxrecapType[] {});
    }

    public void addAllZapi_ZpaxrecapType(Zapi_ZpaxrecapType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Zapi_ZpaxrecapType getZapi_ZpaxrecapType(int index) {
        return (com.kcdata.abe.bapi.Zapi_ZpaxrecapType)baseList().get(index);
    }

    public int indexOfZapi_ZpaxrecapType(com.kcdata.abe.bapi.Zapi_ZpaxrecapType item) {
        return baseList().indexOf(item);
    }

    public boolean containsZapi_ZpaxrecapType(com.kcdata.abe.bapi.Zapi_ZpaxrecapType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Zapi_ZpaxrecapType removeZapi_ZpaxrecapType(int index) {
        return (com.kcdata.abe.bapi.Zapi_ZpaxrecapType)baseList().remove(index);
    }

    public void addZapi_ZpaxrecapType(com.kcdata.abe.bapi.Zapi_ZpaxrecapType item) {
        baseList().add(item);
    }

    public void addAllZapi_ZpaxrecapType(int index, Zapi_ZpaxrecapType_List item) {
        baseList().addAll(index, item);
    }

    public Zapi_ZpaxrecapType_List subListZapi_ZpaxrecapType(int fromIndex, int toIndex) {
        return (Zapi_ZpaxrecapType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Zapi_ZpaxrecapType setZapi_ZpaxrecapType(int index, com.kcdata.abe.bapi.Zapi_ZpaxrecapType item) {
        return (com.kcdata.abe.bapi.Zapi_ZpaxrecapType)baseList().set(index, item);
    }

    public boolean removeZapi_ZpaxrecapType(com.kcdata.abe.bapi.Zapi_ZpaxrecapType item) {
        return baseList().remove(item);
    }

    public boolean containsAllZapi_ZpaxrecapType(Zapi_ZpaxrecapType_List item) {
        return baseList().containsAll(item);
    }

    public void addZapi_ZpaxrecapType(int index, com.kcdata.abe.bapi.Zapi_ZpaxrecapType item) {
        baseList().add(index, item);
    }

    public int lastIndexOfZapi_ZpaxrecapType(com.kcdata.abe.bapi.Zapi_ZpaxrecapType item) {
        return baseList().lastIndexOf(item);
    }

}
