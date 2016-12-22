package org.westbank.api;

import org.westbank.requisition.Requisite;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

/**
 * Created by jacob on 11/15/2016.
 */
public class RequisiteAPI {

    public RequisiteAPI() {

    }

    public Object[] getRequisites() {
        return requisite_list.toArray();
    }

    private List<Object> requisite_list = new ArrayList();

    public void populate(List<Object> pre_populated_list) {
        copy(pre_populated_list, requisite_list);
    }

    public boolean addRequisite(Object requisite) {
        return requisite_list.add(requisite);
    }

}
