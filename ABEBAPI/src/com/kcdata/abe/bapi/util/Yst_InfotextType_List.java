package com.kcdata.abe.bapi.util;
public class Yst_InfotextType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 862959738L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_INFOTEXT", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_InfotextType.class, new com.kcdata.abe.bapi.Yst_InfotextType(), new java.lang.String[][]{}, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_T_INFOTEXT\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Table Type for YST_INFOTEXT</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>tableType</ifr:category><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition><ifr:complexType name=\"YST_INFOTEXT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_INFOTEXT\" /></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_InfotextType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_InfotextType[] toArrayYst_InfotextType() {
        return (com.kcdata.abe.bapi.Yst_InfotextType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_InfotextType[] {});
    }

    public com.kcdata.abe.bapi.Yst_InfotextType setYst_InfotextType(int index, com.kcdata.abe.bapi.Yst_InfotextType item) {
        return (com.kcdata.abe.bapi.Yst_InfotextType)baseList().set(index, item);
    }

    public void addYst_InfotextType(int index, com.kcdata.abe.bapi.Yst_InfotextType item) {
        baseList().add(index, item);
    }

    public void addAllYst_InfotextType(Yst_InfotextType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYst_InfotextType(com.kcdata.abe.bapi.Yst_InfotextType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_InfotextType(Yst_InfotextType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Yst_InfotextType getYst_InfotextType(int index) {
        return (com.kcdata.abe.bapi.Yst_InfotextType)baseList().get(index);
    }

    public void addYst_InfotextType(com.kcdata.abe.bapi.Yst_InfotextType item) {
        baseList().add(item);
    }

    public void addAllYst_InfotextType(int index, Yst_InfotextType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsYst_InfotextType(com.kcdata.abe.bapi.Yst_InfotextType item) {
        return baseList().contains(item);
    }

    public Yst_InfotextType_List subListYst_InfotextType(int fromIndex, int toIndex) {
        return (Yst_InfotextType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yst_InfotextType removeYst_InfotextType(int index) {
        return (com.kcdata.abe.bapi.Yst_InfotextType)baseList().remove(index);
    }

    public int lastIndexOfYst_InfotextType(com.kcdata.abe.bapi.Yst_InfotextType item) {
        return baseList().lastIndexOf(item);
    }

    public int indexOfYst_InfotextType(com.kcdata.abe.bapi.Yst_InfotextType item) {
        return baseList().indexOf(item);
    }

}
