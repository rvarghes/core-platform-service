package com.kcdata.abe.bapi.util;
public class ZshcharType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1497187105L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZSHCHAR", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.ZshcharType.class, new com.kcdata.abe.bapi.ZshcharType(), new java.lang.String[][]{}, 60, 120, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZSHCHAR\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Hotel selection char value and char value description</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>60</ifr:internalLength1><ifr:internalLength2>120</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  ZshcharType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public ZshcharType_List subListZshcharType(int fromIndex, int toIndex) {
        return (ZshcharType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean containsZshcharType(com.kcdata.abe.bapi.ZshcharType item) {
        return baseList().contains(item);
    }

    public int indexOfZshcharType(com.kcdata.abe.bapi.ZshcharType item) {
        return baseList().indexOf(item);
    }

    public void addZshcharType(int index, com.kcdata.abe.bapi.ZshcharType item) {
        baseList().add(index, item);
    }

    public void addAllZshcharType(ZshcharType_List item) {
        baseList().addAll(item);
    }

    public void addAllZshcharType(int index, ZshcharType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsAllZshcharType(ZshcharType_List item) {
        return baseList().containsAll(item);
    }

    public boolean removeZshcharType(com.kcdata.abe.bapi.ZshcharType item) {
        return baseList().remove(item);
    }

    public com.kcdata.abe.bapi.ZshcharType removeZshcharType(int index) {
        return (com.kcdata.abe.bapi.ZshcharType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.ZshcharType getZshcharType(int index) {
        return (com.kcdata.abe.bapi.ZshcharType)baseList().get(index);
    }

    public com.kcdata.abe.bapi.ZshcharType[] toArrayZshcharType() {
        return (com.kcdata.abe.bapi.ZshcharType[])baseList().toArray(new com.kcdata.abe.bapi.ZshcharType[] {});
    }

    public com.kcdata.abe.bapi.ZshcharType setZshcharType(int index, com.kcdata.abe.bapi.ZshcharType item) {
        return (com.kcdata.abe.bapi.ZshcharType)baseList().set(index, item);
    }

    public void addZshcharType(com.kcdata.abe.bapi.ZshcharType item) {
        baseList().add(item);
    }

    public int lastIndexOfZshcharType(com.kcdata.abe.bapi.ZshcharType item) {
        return baseList().lastIndexOf(item);
    }

}
