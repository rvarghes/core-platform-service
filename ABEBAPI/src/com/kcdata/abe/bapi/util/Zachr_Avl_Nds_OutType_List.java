package com.kcdata.abe.bapi.util;
public class Zachr_Avl_Nds_OutType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1324053787L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZACHR_AVL_NDS_OUT", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType.class, new com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType(), new java.lang.String[][]{}, 140, 272, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZACHR_AVL_NDS_OUT\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">NDS -  Charter air availability o/p data.</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>140</ifr:internalLength1><ifr:internalLength2>272</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zachr_Avl_Nds_OutType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsZachr_Avl_Nds_OutType(com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType item) {
        return baseList().contains(item);
    }

    public void addAllZachr_Avl_Nds_OutType(int index, Zachr_Avl_Nds_OutType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType removeZachr_Avl_Nds_OutType(int index) {
        return (com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType)baseList().remove(index);
    }

    public Zachr_Avl_Nds_OutType_List subListZachr_Avl_Nds_OutType(int fromIndex, int toIndex) {
        return (Zachr_Avl_Nds_OutType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllZachr_Avl_Nds_OutType(Zachr_Avl_Nds_OutType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllZachr_Avl_Nds_OutType(Zachr_Avl_Nds_OutType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType setZachr_Avl_Nds_OutType(int index, com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType item) {
        return (com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType)baseList().set(index, item);
    }

    public int indexOfZachr_Avl_Nds_OutType(com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType item) {
        return baseList().indexOf(item);
    }

    public void addZachr_Avl_Nds_OutType(int index, com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType getZachr_Avl_Nds_OutType(int index) {
        return (com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType)baseList().get(index);
    }

    public boolean removeZachr_Avl_Nds_OutType(com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType item) {
        return baseList().remove(item);
    }

    public int lastIndexOfZachr_Avl_Nds_OutType(com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType item) {
        return baseList().lastIndexOf(item);
    }

    public void addZachr_Avl_Nds_OutType(com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType[] toArrayZachr_Avl_Nds_OutType() {
        return (com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType[])baseList().toArray(new com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType[] {});
    }

}
