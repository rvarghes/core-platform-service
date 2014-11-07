package com.kcdata.abe.bapi.util;
public class Yst_Htl_ItemsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -364764362L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_HTL_ITEMS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Htl_ItemsType.class, new com.kcdata.abe.bapi.Yst_Htl_ItemsType(), new java.lang.String[][]{}, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_T_HTL_ITEMS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Table type for YST_HTL_ITEMS</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>tableType</ifr:category><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition><ifr:complexType name=\"YST_HTL_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_HTL_ITEMS\" /></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Htl_ItemsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean removeYst_Htl_ItemsType(com.kcdata.abe.bapi.Yst_Htl_ItemsType item) {
        return baseList().remove(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_ItemsType[] toArrayYst_Htl_ItemsType() {
        return (com.kcdata.abe.bapi.Yst_Htl_ItemsType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Htl_ItemsType[] {});
    }

    public void addYst_Htl_ItemsType(com.kcdata.abe.bapi.Yst_Htl_ItemsType item) {
        baseList().add(item);
    }

    public boolean containsYst_Htl_ItemsType(com.kcdata.abe.bapi.Yst_Htl_ItemsType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_ItemsType setYst_Htl_ItemsType(int index, com.kcdata.abe.bapi.Yst_Htl_ItemsType item) {
        return (com.kcdata.abe.bapi.Yst_Htl_ItemsType)baseList().set(index, item);
    }

    public void addYst_Htl_ItemsType(int index, com.kcdata.abe.bapi.Yst_Htl_ItemsType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_ItemsType removeYst_Htl_ItemsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Htl_ItemsType)baseList().remove(index);
    }

    public void addAllYst_Htl_ItemsType(int index, Yst_Htl_ItemsType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllYst_Htl_ItemsType(Yst_Htl_ItemsType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllYst_Htl_ItemsType(Yst_Htl_ItemsType_List item) {
        return baseList().containsAll(item);
    }

    public Yst_Htl_ItemsType_List subListYst_Htl_ItemsType(int fromIndex, int toIndex) {
        return (Yst_Htl_ItemsType_List)baseList().subList(fromIndex, toIndex);
    }

    public int lastIndexOfYst_Htl_ItemsType(com.kcdata.abe.bapi.Yst_Htl_ItemsType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_ItemsType getYst_Htl_ItemsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Htl_ItemsType)baseList().get(index);
    }

    public int indexOfYst_Htl_ItemsType(com.kcdata.abe.bapi.Yst_Htl_ItemsType item) {
        return baseList().indexOf(item);
    }

}
