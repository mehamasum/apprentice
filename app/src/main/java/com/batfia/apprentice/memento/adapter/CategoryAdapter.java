package com.batfia.apprentice.memento.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.batfia.apprentice.R;

import java.util.ArrayList;

import com.batfia.apprentice.memento.adapter.template.ModelAdapter;
import com.batfia.apprentice.memento.model.Category;
import com.batfia.apprentice.memento.widget.CategoryViewHolder;

public class CategoryAdapter extends ModelAdapter<Category, CategoryViewHolder> {
	public CategoryAdapter(ArrayList<Category> items, ArrayList<Category> selected, ClickListener<Category> listener) {
		super(items, selected, listener);
	}

	@Override
	public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false));
	}
}
