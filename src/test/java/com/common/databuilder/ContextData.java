package com.common.databuilder;

import java.io.Serializable;
import org.apache.commons.lang.SerializationException;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContextData implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(ContextData.class);
	 
	private int numberCount;
	private WebElement element;
	private Keys key;
	private boolean doPressEnter;
	private boolean doPressReturn;
	private boolean isContextClick;
	private boolean isSlider;

	public ContextData() {
        super();
        numberCount = 0;
		element = null;
		key = null;
		doPressEnter = false;
		doPressReturn = false;
		isContextClick = false;
		isSlider = false;
    }
	
	public int getnumberCount() {
		return numberCount;
	}

	public void setnumberCount(int number) {
		this.numberCount = number;
	}

	public WebElement getElement() {
		return element;
	}

	public void setElement(WebElement element) {
		this.element = element;
	}

	public Keys getKey() {
		return key;
	}

	public void setKey(Keys key) {
		this.key = key;
	}

	public boolean isDoPressEnter() {
		return doPressEnter;
	}

	public void setDoPressEnter(boolean doPressEnter) {
		this.doPressEnter = doPressEnter;
	}

	public boolean isDoPressReturn() {
		return doPressReturn;
	}

	public void setDoPressReturn(boolean doPressReturn) {
		this.doPressReturn = doPressReturn;
	}

	public boolean isContextClick() {
		return isContextClick;
	}

	public void setContextClick(boolean isContextClick) {
		this.isContextClick = isContextClick;
	}

	public boolean isSlider() {
		return isSlider;
	}

	public void setSlider(boolean isSlider) {
		this.isSlider = isSlider;
	}
	
    /**
     * Deep-Copy of the reservation data.
     *
     * @return the new ReservationData object
     */
    public ContextData copyContextData() {
    	ContextData answer = null;
        try {
            answer = (ContextData) SerializationUtils.clone(this);
        } catch (SerializationException e) {
            logger.error(StringUtils.EMPTY, e);
        }
        return answer;
    }
}
