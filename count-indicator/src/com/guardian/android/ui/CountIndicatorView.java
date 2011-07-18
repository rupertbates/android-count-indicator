package com.guardian.android.ui;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CountIndicatorView extends View {
    protected int numberOfItems = 6;
    protected int itemSpacing = 12;
    protected int radius = 12;
    private int numberSelected = 3;
    private int unSelectedColour = R.color.unselected_item;
    private int selectedColour = R.color.selected_item;

    public CountIndicatorView(Context context) {
        super(context);
    }

    public CountIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        TypedArray styledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CountIndicatorView);
        radius = styledAttributes.getInt(R.styleable.CountIndicatorView_radius, radius);
        numberOfItems = styledAttributes.getInt(R.styleable.CountIndicatorView_numberOfItems, numberOfItems);
        numberSelected = styledAttributes.getInt(R.styleable.CountIndicatorView_numberSelected, numberSelected);
        itemSpacing = styledAttributes.getInt(R.styleable.CountIndicatorView_itemSpacing, itemSpacing);
        selectedColour = styledAttributes.getColor(R.styleable.CountIndicatorView_selectedColor, selectedColour);
        unSelectedColour = styledAttributes.getColor(R.styleable.CountIndicatorView_unSelectedColor, unSelectedColour);

        styledAttributes.recycle();
    }

    public int getItemSpacing() {
        return itemSpacing;
    }

    public void setItemSpacing(int itemSpacing) {
        this.itemSpacing = itemSpacing;
        requestLayout();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        requestLayout();
    }

    public int getUnSelectedColour() {
        return unSelectedColour;
    }

    public void setUnSelectedColour(int unSelectedColour) {
        this.unSelectedColour = unSelectedColour;
        invalidate();
    }

    public int getSelectedColour() {
        return selectedColour;
    }

    public void setSelectedColour(int selectedColour) {
        this.selectedColour = selectedColour;
        invalidate();
    }


    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
        requestLayout();
    }

    public void setNumberSelected(int number) {
        this.numberSelected = number;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < numberOfItems; i++) {
            float x = i * itemSpacing + (i * (radius * 2)) + radius + getPaddingLeft();
            float y = radius + getPaddingTop();
            canvas.drawCircle(x, y, radius, getPaint(i));
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);    //To change body of overridden methods use File | Settings | File Templates.
        int width = (numberOfItems * (radius * 2)) + ((numberOfItems - 1) * itemSpacing) + getPaddingLeft() + getPaddingRight();
        int height = (2 * radius) + getPaddingBottom() + getPaddingTop();
        setMeasuredDimension(width, height);
    }


    private Paint getPaint(int i) {
        int colour = i >= numberSelected ? unSelectedColour : selectedColour;
        Paint p = new Paint();
        p.setColor(getResources().getColor(colour));
        return p;
    }

}
