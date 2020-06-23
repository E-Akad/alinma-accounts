/**
 * 
 */
package com.alinma.rib.accounts.model.response;

import java.io.Serializable;

/**
 * @author Waleed Tayea
 * Marker interface for all the identifiers.
 */
public interface EntityKey extends Serializable{
	String getCode();
}
