package com.kcdata.abe.bapi.util;
public class Zalert_TypType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 2036930120L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZALERT_TYP", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zalert_TypType.class, new com.kcdata.abe.bapi.Zalert_TypType(), new java.lang.String[][]{}, 85, 170, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZALERT_TYP\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Alert Types.</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>false</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>85</ifr:internalLength1><ifr:internalLength2>170</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zalert_TypType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsAllZalert_TypType(Zalert_TypType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Zalert_TypType[] toArrayZalert_TypType() {
        return (com.kcdata.abe.bapi.Zalert_TypType[])baseList().toArray(new com.kcdata.abe.bapi.Zalert_TypType[] {});
    }

    public int lastIndexOfZalert_TypType(com.kcdata.abe.bapi.Zalert_TypType item) {
        return baseList().lastIndexOf(item);
    }

    public Zalert_TypType_List subListZalert_TypType(int fromIndex, int toIndex) {
        return (Zalert_TypType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Zalert_TypType setZalert_TypType(int index, com.kcdata.abe.bapi.Zalert_TypType item) {
        return (com.kcdata.abe.bapi.Zalert_TypType)baseList().set(index, item);
    }

    public void addZalert_TypType(int index, com.kcdata.abe.bapi.Zalert_TypType item) {
        baseList().add(index, item);
    }

    public void addAllZalert_TypType(Zalert_TypType_List item) {
        baseList().addAll(item);
    }

    public boolean removeZalert_TypType(com.kcdata.abe.bapi.Zalert_TypType item) {
        return baseList().remove(item);
    }

    public void addZalert_TypType(com.kcdata.abe.bapi.Zalert_TypType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Zalert_TypType removeZalert_TypType(int index) {
        return (com.kcdata.abe.bapi.Zalert_TypType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Zalert_TypType getZalert_TypType(int index) {
        return (com.kcdata.abe.bapi.Zalert_TypType)baseList().get(index);
    }

    public int indexOfZalert_TypType(com.kcdata.abe.bapi.Zalert_TypType item) {
        return baseList().indexOf(item);
    }

    public boolean containsZalert_TypType(com.kcdata.abe.bapi.Zalert_TypType item) {
        return baseList().contains(item);
    }

    public void addAllZalert_TypType(int index, Zalert_TypType_List item) {
        baseList().addAll(index, item);
    }

}
