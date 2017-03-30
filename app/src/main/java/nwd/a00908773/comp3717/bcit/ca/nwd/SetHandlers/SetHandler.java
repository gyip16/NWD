package nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ColorTemplate;

/**
 * Created by Pkao on 2017-03-29.
 */

public class SetHandler {
    protected DataSet set;

    public SetHandler (DataSet set) {
        this.set = set;
    }

    /**
     * empties the set
     */
    public void clearSet(){
        set.clear();
    }

    /**
     * add entries into the set
     * @param entry
     */
    public void addEntry(Entry entry){
        set.addEntry(entry);
    }

    /**
     * Choose a predefined theme
     * @param theme int to decide theme
     */
    public void setTheme(int theme) {
        switch(theme) {
            case 0:
                set.setColors(ColorTemplate.COLORFUL_COLORS);
                break;
            case 1:
                set.setColors(ColorTemplate.VORDIPLOM_COLORS);
                break;
            case 2:
                set.setColors(ColorTemplate.LIBERTY_COLORS);
                break;
            case 3:
                set.setColors(ColorTemplate.JOYFUL_COLORS);
                break;
            case 4:
                set.setColors(ColorTemplate.MATERIAL_COLORS);
                break;
            case 5:
                set.setColors(ColorTemplate.PASTEL_COLORS);
                break;
            default:
                set.setColors(ColorTemplate.COLOR_NONE);
                break;
        }
    }
}
