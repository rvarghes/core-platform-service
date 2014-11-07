package com.kcdata.abe.bapi.util;
public class Yst_FarerulesType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1033729342L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_FARERULES", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_FarerulesType.class, new com.kcdata.abe.bapi.Yst_FarerulesType(), new java.lang.String[][]{}, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_T_FARERULES\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Table type for YST_FARERULES</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>tableType</ifr:category><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition><ifr:complexType name=\"YST_FARERULES\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_FARERULES\" /></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_FarerulesType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public int lastIndexOfYst_FarerulesType(com.kcdata.abe.bapi.Yst_FarerulesType item) {
        return baseList().lastIndexOf(item);
    }

    public int indexOfYst_FarerulesType(com.kcdata.abe.bapi.Yst_FarerulesType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_FarerulesType removeYst_FarerulesType(int index) {
        return (com.kcdata.abe.bapi.Yst_FarerulesType)baseList().remove(index);
    }

    public boolean removeYst_FarerulesType(com.kcdata.abe.bapi.Yst_FarerulesType item) {
        return baseList().remove(item);
    }

    public void addYst_FarerulesType(com.kcdata.abe.bapi.Yst_FarerulesType item) {
        baseList().add(item);
    }

    public boolean containsYst_FarerulesType(com.kcdata.abe.bapi.Yst_FarerulesType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_FarerulesType setYst_FarerulesType(int index, com.kcdata.abe.bapi.Yst_FarerulesType item) {
        return (com.kcdata.abe.bapi.Yst_FarerulesType)baseList().set(index, item);
    }

    public void addYst_FarerulesType(int index, com.kcdata.abe.bapi.Yst_FarerulesType item) {
        baseList().add(index, item);
    }

    public Yst_FarerulesType_List subListYst_FarerulesType(int fromIndex, int toIndex) {
        return (Yst_FarerulesType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllYst_FarerulesType(int index, Yst_FarerulesType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Yst_FarerulesType[] toArrayYst_FarerulesType() {
        return (com.kcdata.abe.bapi.Yst_FarerulesType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_FarerulesType[] {});
    }

    public void addAllYst_FarerulesType(Yst_FarerulesType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllYst_FarerulesType(Yst_FarerulesType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Yst_FarerulesType getYst_FarerulesType(int index) {
        return (com.kcdata.abe.bapi.Yst_FarerulesType)baseList().get(index);
    }

}
