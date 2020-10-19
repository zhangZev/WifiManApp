package com.wanzhong.core.dialog;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.wanzhong.core.R;

import androidx.cursoradapter.widget.CursorAdapter;

public class CtDialog extends Dialog implements DialogInterface{

	private ImageView mIcon;
	private TextView mAlertTitle;
	private ViewGroup mContentPanel;
	private View mScrollView;
	private TextView mMessage;
	private FrameLayout mCustom;
	private View mButtonPanel;
	private Button mButton1;
	private Button mButton2;
	private Button mButton3;
	//private ImageView mTopCover;
	public CtDialog(Context context) {
		super(context,R.style.CtDialog);
		// TODO Auto-generated constructor stub
		this.setContentView(R.layout.alert_dialog);
		initView();
	}
	public CtDialog(Context context,int layoutID) {
		super(context,R.style.CtDialog);
		// TODO Auto-generated constructor stub
		this.setContentView(layoutID);
		initView();
	}

	public Button getButton(int button){
		switch(button){
			case AlertDialog.BUTTON_POSITIVE:{
				return mButton1;
			}
			case AlertDialog.BUTTON_NEGATIVE:{
				return mButton2;
			}
			case AlertDialog.BUTTON_NEUTRAL:{
				return mButton3;
			}
		}
		return mButton1;
	}
	private void initView(){
		mIcon = (ImageView)findViewById(R.id.icon);
		mAlertTitle = (TextView)findViewById(R.id.alertTitle);
		mContentPanel = (ViewGroup)findViewById(R.id.contentPanel);
		mScrollView = findViewById(R.id.scrollView);
		mMessage = (TextView)findViewById(R.id.message);
		mCustom = (FrameLayout)findViewById(R.id.custom);
		mButtonPanel = findViewById(R.id.buttonPanel);
		mButton1 = (Button)findViewById(R.id.button1);
		mButton2 = (Button)findViewById(R.id.button2);
		mButton3 = (Button)findViewById(R.id.button3);
//		if(findViewById(R.id.top_cover) != null){
//			mTopCover = (ImageView)findViewById(R.id.top_cover);
//		}
		
	}
	
	/*public CtDialog hightLightButton1(){
		mButton1.setBackgroundResource(R.drawable.dialog_button_1_high_light);
		mButton1.setTextColor(this.getContext().getResources().getColorStateList(R.color.dialog_button_color_high_light));
		return this;
	}*/
	public static class Builder {
		private final AlertParams P;

		public Builder(Context context) {
			P = new AlertParams(context);
		}

		/**
         * Creates a {@link AlertDialog} with the arguments supplied to this builder. It does not
         * {@link Dialog#show()} the dialog. This allows the user to do any extra processing
         * before displaying the dialog. Use {@link #show()} if you don't have any other processing
         * to do and want this to be created and displayed.
         */
        public CtDialog create() {
            final CtDialog dialog = new CtDialog(P.mContext);
            P.apply(dialog);
            dialog.setCancelable(P.mCancelable);
            dialog.setOnCancelListener(P.mOnCancelListener);
            if (P.mOnKeyListener != null) {
                dialog.setOnKeyListener(P.mOnKeyListener);
            }
            setTranslucentStatus(dialog.getWindow(),true);
            return dialog;
        }
        public CtDialog create(int layoutID) {
            final CtDialog dialog = new CtDialog(P.mContext,layoutID);
            P.apply(dialog);
            dialog.setCancelable(P.mCancelable);
            dialog.setOnCancelListener(P.mOnCancelListener);
            if (P.mOnKeyListener != null) {
                dialog.setOnKeyListener(P.mOnKeyListener);
            }
            setTranslucentStatus(dialog.getWindow(),true);
            return dialog;
        }
        private void setTranslucentStatus(Window win, boolean on) {
        	 if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT || win == null) {
        		 return;
             } 

            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS/* | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION*/;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
        /**
         * Creates a {@link AlertDialog} with the arguments supplied to this builder and
         * {@link Dialog#show()}'s the dialog.
         */
        public Dialog show() {
            Dialog dialog = create();
            dialog.show();
            
            return dialog;
        }
        
		public Builder setTitle(int titleId) {
			P.mTitle = P.mContext.getText(titleId);
			return this;
		}

		public Builder setTopCover(int imageId){
			P.mTopCoverId = imageId;
			return this;
		}
		/**
		 * Set the title displayed in the {@link Dialog}.
		 * 
		 * @return This Builder object to allow for chaining of calls to set
		 *         methods
		 */
		public Builder setTitle(CharSequence title) {
			P.mTitle = title;
			return this;
		}

		/**
         * Set the message to display using the given resource id.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setMessage(int messageId) {
            P.mMessage = P.mContext.getText(messageId);
            return this;
        }

        public Builder setMessageTextColor(int color) {
            P.mMsgColor = color;
            return this;
        }
        public Builder setMessageTopIcon(Drawable drawable) {
            P.mMsgTopIcon = drawable;
            return this;
        }
        
        /**
         * Set the message to display.
          *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setMessage(CharSequence message) {
            P.mMessage = message;
            return this;
        }
        
        /**
         * Set the resource id of the {@link Drawable} to be used in the title.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setIcon(int iconId) {
            //P.mIconId = iconId;
            return this;
        }
        
        /**
         * Set the {@link Drawable} to be used in the title.
          *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setIcon(Drawable icon) {
            //P.mIcon = icon;
            return this;
        }
        
        /**
         * Set a listener to be invoked when the positive button of the dialog is pressed.
         * @param textId The resource id of the text to display in the positive button
         * @param listener The {@link OnClickListener} to use.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setPositiveButton(int textId, final OnClickListener listener) {
            P.mPositiveButtonText = P.mContext.getText(textId);
            P.mPositiveButtonListener = listener;
            return this;
        }
        
        /**
         * Set a listener to be invoked when the positive button of the dialog is pressed.
         * @param text The text to display in the positive button
         * @param listener The {@link OnClickListener} to use.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setPositiveButton(CharSequence text, final OnClickListener listener) {
            P.mPositiveButtonText = text;
            P.mPositiveButtonListener = listener;
            return this;
        }
        
        /**
         * Set a listener to be invoked when the negative button of the dialog is pressed.
         * @param textId The resource id of the text to display in the negative button
         * @param listener The {@link OnClickListener} to use.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setNegativeButton(int textId, final OnClickListener listener) {
            P.mNegativeButtonText = P.mContext.getText(textId);
            P.mNegativeButtonListener = listener;
            return this;
        }
        
        /**
         * Set a listener to be invoked when the negative button of the dialog is pressed.
         * @param text The text to display in the negative button
         * @param listener The {@link OnClickListener} to use.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setNegativeButton(CharSequence text, final OnClickListener listener) {
            P.mNegativeButtonText = text;
            P.mNegativeButtonListener = listener;
            return this;
        }
        
        /**
         * Set a listener to be invoked when the neutral button of the dialog is pressed.
         * @param textId The resource id of the text to display in the neutral button
         * @param listener The {@link OnClickListener} to use.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setNeutralButton(int textId, final OnClickListener listener) {
            P.mNeutralButtonText = P.mContext.getText(textId);
            P.mNeutralButtonListener = listener;
            return this;
        }
        
        /**
         * Set a listener to be invoked when the neutral button of the dialog is pressed.
         * @param text The text to display in the neutral button
         * @param listener The {@link OnClickListener} to use.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setNeutralButton(CharSequence text, final OnClickListener listener) {
            P.mNeutralButtonText = text;
            P.mNeutralButtonListener = listener;
            return this;
        }
        
        /**
         * Sets whether the dialog is cancelable or not.  Default is true.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setCancelable(boolean cancelable) {
            P.mCancelable = cancelable;
            return this;
        }
        
        /**
         * Sets the callback that will be called if the dialog is canceled.
         * @see #setCancelable(boolean)
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            P.mOnCancelListener = onCancelListener;
            return this;
        }
        
        /**
         * Set a custom view to be the contents of the Dialog. If the supplied view is an instance
         * of a {@link ListView} the light background will be used.
         *
         * @param view The view to use as the contents of the Dialog.
         * 
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setView(View view) {
            P.mView = view;
            if(P.mView instanceof TextView){
            	((TextView)P.mView).setTextSize(14);
            }
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content,
         * you will be notified of the selected item via the supplied listener.
         * This should be an array type, e.g. R.array.foo. The list will have
         * a check mark displayed to the right of the text for each checked
         * item. Clicking on an item in the list will not dismiss the dialog.
         * Clicking on a button will dismiss the dialog.
         * 
         * @param itemsId the resource id of an array i.e. R.array.foo
         * @param checkedItems specifies which items are checked. It should be null in which case no
         *        items are checked. If non null it must be exactly the same length as the array of
         *        items.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setMultiChoiceItems(int itemsId, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content,
         * you will be notified of the selected item via the supplied listener.
         * The list will have a check mark displayed to the right of the text
         * for each checked item. Clicking on an item in the list will not
         * dismiss the dialog. Clicking on a button will dismiss the dialog.
         * 
         * @param items the text of the items to be displayed in the list.
         * @param checkedItems specifies which items are checked. It should be null in which case no
         *        items are checked. If non null it must be exactly the same length as the array of
         *        items.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            P.mItems = items;
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of
         * the selected item via the supplied listener. This should be an array type i.e.
         * R.array.foo The list will have a check mark displayed to the right of the text for the
         * checked item. Clicking on an item in the list will not dismiss the dialog. Clicking on a
         * button will dismiss the dialog.
         * 
         * @param itemsId the resource id of an array i.e. R.array.foo
         * @param checkedItem specifies which item is checked. If -1 no items are checked.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setSingleChoiceItems(int itemsId, int checkedItem, 
                final OnClickListener listener) {
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of
         * the selected item via the supplied listener. The list will have a check mark displayed to
         * the right of the text for the checked item. Clicking on an item in the list will not
         * dismiss the dialog. Clicking on a button will dismiss the dialog.
         * 
         * @param cursor the cursor to retrieve the items from.
         * @param checkedItem specifies which item is checked. If -1 no items are checked.
         * @param labelColumn The column name on the cursor containing the string to display in the
         *        label.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setSingleChoiceItems(Cursor cursor, int checkedItem, String labelColumn, 
                final OnClickListener listener) {
            P.mCursor = cursor;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mLabelColumn = labelColumn;
            P.mIsSingleChoice = true;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of
         * the selected item via the supplied listener. The list will have a check mark displayed to
         * the right of the text for the checked item. Clicking on an item in the list will not
         * dismiss the dialog. Clicking on a button will dismiss the dialog.
         * 
         * @param items the items to be displayed.
         * @param checkedItem specifies which item is checked. If -1 no items are checked.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, final OnClickListener listener) {
            P.mItems = items;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            return this;
        } 
        
        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of
         * the selected item via the supplied listener. The list will have a check mark displayed to
         * the right of the text for the checked item. Clicking on an item in the list will not
         * dismiss the dialog. Clicking on a button will dismiss the dialog.
         * 
         * @param adapter The {@link ListAdapter} to supply the list of items
         * @param checkedItem specifies which item is checked. If -1 no items are checked.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setSingleChoiceItems(ListAdapter adapter, int checkedItem, final OnClickListener listener) {
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            return this;
        }
        
        /**
         * Sets the callback that will be called if a key is dispatched to the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            P.mOnKeyListener = onKeyListener;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of the
         * selected item via the supplied listener. This should be an array type i.e. R.array.foo
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setItems(int itemsId, final OnClickListener listener) {
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of the
         * selected item via the supplied listener.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setItems(CharSequence[] items, final OnClickListener listener) {
            P.mItems = items;
            P.mOnClickListener = listener;
            return this;
        }
	}
	 
	 
	 
	 public static class AlertParams {
	        public final Context mContext;
	        public final LayoutInflater mInflater;
	        
	        public int mIconId = 0;
	        public Drawable mIcon;
	        public CharSequence mTitle;
	        public CharSequence mMessage;
	        public int mMsgColor = 0;
	        public Drawable mMsgTopIcon;
	        private ListView mListView;
	        public CharSequence mPositiveButtonText;
	        public OnClickListener mPositiveButtonListener;
	        public CharSequence mNegativeButtonText;
	        public OnClickListener mNegativeButtonListener;
	        public CharSequence mNeutralButtonText;
	        public OnClickListener mNeutralButtonListener;
	        public boolean mCancelable;
	        public OnCancelListener mOnCancelListener;
	        public OnKeyListener mOnKeyListener;
	        public CharSequence[] mItems;
	        public ListAdapter mAdapter;
	        public OnClickListener mOnClickListener;
	        public View mView;

	        public boolean[] mCheckedItems;
	        public boolean mIsMultiChoice;
	        public boolean mIsSingleChoice;
	        public int mCheckedItem = -1;
	        public OnMultiChoiceClickListener mOnCheckboxClickListener;
	        public String mLabelColumn;
	        public String mIsCheckedColumn;
	        public boolean mForceInverseBackground;
	        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
	        public Cursor mCursor;
	        
	        public int mTopCoverId;
	        /**
	         * Interface definition for a callback to be invoked before the ListView
	         * will be bound to an adapter.
	         */
	        public interface OnPrepareListViewListener {
	            
	            /**
	             * Called before the ListView is bound to an adapter.
	             * @param listView The ListView that will be shown in the dialog.
	             */
	            void onPrepareListView(ListView listView);
	        }
	        
	        public AlertParams(Context context) {
	            mContext = context;
	            mCancelable = true;
	            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        }

	        public void apply(CtDialog dialog) {
	        	if (!TextUtils.isEmpty(mTitle)) {
	        		dialog.mAlertTitle.setText(mTitle);
                } else {
                	((View)dialog.mAlertTitle.getParent().getParent()).setVisibility(View.GONE);
                }
                if (mIcon != null) {
                	dialog.mIcon.setImageDrawable(mIcon);
                }
                if (mIconId >= 0) {
                    dialog.mIcon.setImageResource(mIconId);
                }
                if (mMessage != null) {
                    dialog.mMessage.setText(mMessage);
                }
                if(mMsgColor !=  0){
                    dialog.mMessage.setTextColor(mMsgColor);
                }
                if(mMsgTopIcon != null){
                    dialog.mMessage.setCompoundDrawablesWithIntrinsicBounds(null,mMsgTopIcon,null,null);
                }
                ButtonHandler mButtonHandler = new ButtonHandler(dialog);
                if (mPositiveButtonText != null) {
                	dialog.mButton1.setText(mPositiveButtonText);
                	dialog.mButton1.setOnClickListener(mButtonHandler);
                	dialog.mButton1.setTag(mPositiveButtonListener);
                } else {
                	((View)dialog.mButton1.getParent()).setVisibility(View.GONE);
                	
                }
                if (mNegativeButtonText != null) {
                	dialog.mButton2.setText(mNegativeButtonText);
                	dialog.mButton2.setOnClickListener(mButtonHandler);
                	dialog.mButton2.setTag(mNegativeButtonListener);
                } else {
                	dialog.mButton2.setVisibility(View.GONE);
                }
                if (mNeutralButtonText != null) {
                	dialog.mButton3.setText(mNeutralButtonText);
                	dialog.mButton3.setOnClickListener(mButtonHandler);
                	dialog.mButton3.setTag(mNeutralButtonListener);
                } else {
                	((View)dialog.mButton3.getParent()).setVisibility(View.GONE);
                }
                if(mPositiveButtonText == null && mNegativeButtonText == null && mNeutralButtonText == null){
                	dialog.mButtonPanel.setVisibility(View.GONE);
                } else if(mPositiveButtonText != null && mNegativeButtonText == null && mNeutralButtonText == null){
                	dialog.mButtonPanel.setVisibility(View.VISIBLE);

                } 
                dialog.mButtonPanel.setVisibility(View.VISIBLE);
             // For a list, the client can either supply an array of items or an
                // adapter or a cursor
                if ((mItems != null) || (mAdapter != null)) {
                    createListView(dialog);
                    mListView.setAdapter(mAdapter);
                    if (mCheckedItem > -1) {
                        mListView.setItemChecked(mCheckedItem, true);
                        mListView.setSelection(mCheckedItem);
                    }
                    dialog.mContentPanel.removeAllViews();
                    dialog.mContentPanel.addView(mListView);
                }
                if (mView != null) {
                	dialog.mCustom.removeAllViews();
                	dialog.mCustom.addView(mView);
                	dialog.mCustom.setPadding(dialog.mCustom.getPaddingLeft(), dialog.mCustom.getPaddingTop(),
                			dialog.mCustom.getPaddingRight(), dialog.mScrollView.getPaddingBottom());
                	dialog.mScrollView.setPadding(dialog.mScrollView.getPaddingLeft(), dialog.mScrollView.getPaddingTop(),
                			dialog.mScrollView.getPaddingRight(), dialog.mScrollView.getPaddingBottom() / 2);
                	
                } else {
                	dialog.mCustom.setVisibility(View.GONE);
                }
                
/*                if(dialog.mTopCover != null){
                	if(mTopCoverId > 0){
                		dialog.mTopCover.setBackgroundResource(mTopCoverId);
                		RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)dialog.mTopCover.getLayoutParams();
                		params.height = App.getInstance().mScreenWidth * 413 / 720;
                		dialog.mTopCover.setLayoutParams(params);
                		dialog.mTopCover.setVisibility(View.VISIBLE);
                	} else {
                		dialog.mTopCover.setVisibility(View.GONE);
                	}
                }*/
	        }
	        
	        private void createListView(final CtDialog dialog) {
	            final ListView listView = new ListView(mContext);/*(ListView)
	                    mInflater.inflate(R.layout.select_dialog, null);*/
	            listView.setDivider(null);
	            //listView.setSelector(R.drawable.dialog_selector);
	            ListAdapter adapter;
	            
	            if (mIsMultiChoice) {
	                if (mCursor == null) {
	                    adapter = new ArrayAdapter<CharSequence>(
	                            mContext, android.R.layout.select_dialog_multichoice, android.R.id.text1, mItems) {
									@Override
									public View getView(int position,
											View convertView, ViewGroup parent) {
										// TODO Auto-generated method stub
										View view = super.getView(position, convertView, parent);
			                            if (mCheckedItems != null) {
			                                boolean isItemChecked = mCheckedItems[position];
			                                if (isItemChecked) {
			                                    listView.setItemChecked(position, true);
			                                }
			                            }
			                            return view;
									}
	                    };
	                } else {
	                    adapter = new CursorAdapter(mContext, mCursor, false) {
	                        private final int mLabelIndex;
	                        private final int mIsCheckedIndex;

	                        {
	                            final Cursor cursor = getCursor();
	                            mLabelIndex = cursor.getColumnIndexOrThrow(mLabelColumn);
	                            mIsCheckedIndex = cursor.getColumnIndexOrThrow(mIsCheckedColumn);
	                        }

	                        @Override
	                        public void bindView(View view, Context context, Cursor cursor) {
	                            CheckedTextView text = (CheckedTextView) view.findViewById(android.R.id.text1);
	                            text.setText(cursor.getString(mLabelIndex));
	                            listView.setItemChecked(cursor.getPosition(),
	                                    cursor.getInt(mIsCheckedIndex) == 1);
	                        }
	    
	                        @Override
	                        public View newView(Context context, Cursor cursor, ViewGroup parent) {
	                            return mInflater.inflate(android.R.layout.select_dialog_multichoice,
	                                    parent, false);
	                        }
	                        
	                    };
	                }
	            } else {
	                int layout = mIsSingleChoice 
	                        ? android.R.layout.select_dialog_singlechoice : android.R.layout.select_dialog_item;
	                if (mCursor == null) {
	                    adapter = (mAdapter != null) ? mAdapter
	                            : new ArrayAdapter<CharSequence>(mContext, layout, android.R.id.text1, mItems);
	                } else {
	                    adapter = new SimpleCursorAdapter(mContext, layout,
	                            mCursor, new String[]{mLabelColumn}, new int[]{android.R.id.text1});
	                }
	            }
	            
	          /*  if (mOnPrepareListViewListener != null) {
	                mOnPrepareListViewListener.onPrepareListView(listView);
	            }*/

	             
	            mAdapter = adapter;
	            mCheckedItem = mCheckedItem;
	            
	            if (mOnClickListener != null) {
	                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	                    public void onItemClick(AdapterView parent, View v, int position, long id) {
	                        mOnClickListener.onClick(dialog, position);
	                        if (!mIsSingleChoice) {
	                            dialog.dismiss();
	                        }
	                    }
	                });
	            } else if (mOnCheckboxClickListener != null) {
	                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	                    public void onItemClick(AdapterView parent, View v, int position, long id) {
	                        if (mCheckedItems != null) {
	                            mCheckedItems[position] = listView.isItemChecked(position);
	                        }
	                        mOnCheckboxClickListener.onClick(
	                                dialog, position, listView.isItemChecked(position));
	                    }
	                });
	            }
	            
	            // Attach a given OnItemSelectedListener to the ListView
	            if (mOnItemSelectedListener != null) {
	                listView.setOnItemSelectedListener(mOnItemSelectedListener);
	            }
	            
	            if (mIsSingleChoice) {
	                listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	            } else if (mIsMultiChoice) {
	                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	            }
	            //listView.mRecycleOnMeasure = mRecycleOnMeasure;
	            mListView = listView;
	        }
	        
	        class ButtonHandler implements View.OnClickListener {
	        	CtDialog mCtDialog;
	        	public ButtonHandler(CtDialog dialog){
	        		mCtDialog = dialog;
	        	}
				public void onClick(View v) {
					if (v == mCtDialog.mButton1 && v.getTag() != null) {
						final OnClickListener listener = (OnClickListener) v.getTag();
						listener.onClick(mCtDialog, DialogInterface.BUTTON_POSITIVE);
					} else if (v == mCtDialog.mButton2 && v.getTag() != null) {
						final OnClickListener listener = (OnClickListener) v.getTag();
						listener.onClick(mCtDialog, DialogInterface.BUTTON_NEGATIVE);
					}  else if (v == mCtDialog.mButton3 && v.getTag() != null) {
						final OnClickListener listener = (OnClickListener) v.getTag();
						listener.onClick(mCtDialog, DialogInterface.BUTTON_NEUTRAL);
					} 
					mCtDialog.dismiss();
				}
			};
	        
	    }
		  
		
}
