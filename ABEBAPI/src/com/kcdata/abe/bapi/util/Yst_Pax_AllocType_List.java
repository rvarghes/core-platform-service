package com.kcdata.abe.bapi.util;
public class Yst_Pax_AllocType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1519020850L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_PAX_ALLOC", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Pax_AllocType.class, new com.kcdata.abe.bapi.Yst_Pax_AllocType(), new java.lang.String[][]{}, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_T_PAX_ALLOC\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Table type for YST_PAX_ALLOC</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>tableType</ifr:category><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition><ifr:complexType name=\"YST_PAX_ALLOC\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_PAX_ALLOC\" /></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Pax_AllocType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Pax_AllocType removeYst_Pax_AllocType(int index) {
        return (com.kcdata.abe.bapi.Yst_Pax_AllocType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Pax_AllocType[] toArrayYst_Pax_AllocType() {
        return (com.kcdata.abe.bapi.Yst_Pax_AllocType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Pax_AllocType[] {});
    }

    public int lastIndexOfYst_Pax_AllocType(com.kcdata.abe.bapi.Yst_Pax_AllocType item) {
        return baseList().lastIndexOf(item);
    }

    public Yst_Pax_AllocType_List subListYst_Pax_AllocType(int fromIndex, int toIndex) {
        return (Yst_Pax_AllocType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllYst_Pax_AllocType(int index, Yst_Pax_AllocType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Pax_AllocType getYst_Pax_AllocType(int index) {
        return (com.kcdata.abe.bapi.Yst_Pax_AllocType)baseList().get(index);
    }

    public void addAllYst_Pax_AllocType(Yst_Pax_AllocType_List item) {
        baseList().addAll(item);
    }

    public int indexOfYst_Pax_AllocType(com.kcdata.abe.bapi.Yst_Pax_AllocType item) {
        return baseList().indexOf(item);
    }

    public boolean containsAllYst_Pax_AllocType(Yst_Pax_AllocType_List item) {
        return baseList().containsAll(item);
    }

    public boolean removeYst_Pax_AllocType(com.kcdata.abe.bapi.Yst_Pax_AllocType item) {
        return baseList().remove(item);
    }

    public void addYst_Pax_AllocType(com.kcdata.abe.bapi.Yst_Pax_AllocType item) {
        baseList().add(item);
    }

    public boolean containsYst_Pax_AllocType(com.kcdata.abe.bapi.Yst_Pax_AllocType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Pax_AllocType setYst_Pax_AllocType(int index, com.kcdata.abe.bapi.Yst_Pax_AllocType item) {
        return (com.kcdata.abe.bapi.Yst_Pax_AllocType)baseList().set(index, item);
    }

    public void addYst_Pax_AllocType(int index, com.kcdata.abe.bapi.Yst_Pax_AllocType item) {
        baseList().add(index, item);
    }

}
