package com.kcdata.abe.bapi.util;
public class Zalert_ItType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 853748930L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZALERT_IT", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zalert_ItType.class, new com.kcdata.abe.bapi.Zalert_ItType(), new java.lang.String[][]{}, 871, 1742, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZALERT_IT\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OPS Alert Item Information.</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>false</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>871</ifr:internalLength1><ifr:internalLength2>1742</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zalert_ItType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsAllZalert_ItType(Zalert_ItType_List item) {
        return baseList().containsAll(item);
    }

    public boolean removeZalert_ItType(com.kcdata.abe.bapi.Zalert_ItType item) {
        return baseList().remove(item);
    }

    public int indexOfZalert_ItType(com.kcdata.abe.bapi.Zalert_ItType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Zalert_ItType removeZalert_ItType(int index) {
        return (com.kcdata.abe.bapi.Zalert_ItType)baseList().remove(index);
    }

    public void addZalert_ItType(int index, com.kcdata.abe.bapi.Zalert_ItType item) {
        baseList().add(index, item);
    }

    public boolean containsZalert_ItType(com.kcdata.abe.bapi.Zalert_ItType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Zalert_ItType setZalert_ItType(int index, com.kcdata.abe.bapi.Zalert_ItType item) {
        return (com.kcdata.abe.bapi.Zalert_ItType)baseList().set(index, item);
    }

    public Zalert_ItType_List subListZalert_ItType(int fromIndex, int toIndex) {
        return (Zalert_ItType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllZalert_ItType(int index, Zalert_ItType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Zalert_ItType[] toArrayZalert_ItType() {
        return (com.kcdata.abe.bapi.Zalert_ItType[])baseList().toArray(new com.kcdata.abe.bapi.Zalert_ItType[] {});
    }

    public int lastIndexOfZalert_ItType(com.kcdata.abe.bapi.Zalert_ItType item) {
        return baseList().lastIndexOf(item);
    }

    public void addZalert_ItType(com.kcdata.abe.bapi.Zalert_ItType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Zalert_ItType getZalert_ItType(int index) {
        return (com.kcdata.abe.bapi.Zalert_ItType)baseList().get(index);
    }

    public void addAllZalert_ItType(Zalert_ItType_List item) {
        baseList().addAll(item);
    }

}
