package com.study.pengnix.ok.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.study.pengnix.ok.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuhaopeng on 2020/6/18.
 */

public class CommentRecyclerAdapter extends SecondaryListAdapter<CommentRecyclerAdapter.GroupItemViewHolder, CommentRecyclerAdapter.SubItemViewHolder> {


    private Context context;

    private List<DataTree<String, String>> dts = new ArrayList<>();

    public CommentRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setData(List datas) {
        dts = datas;
        notifyNewData(dts);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemStatus itemStatus = getItemStatusByPosition(position);

        final DataTree dt = dataTrees.get(itemStatus.getGroupItemIndex());

        if ( itemStatus.getViewType() == ItemStatus.VIEW_TYPE_GROUPITEM ) {

            onGroupItemBindViewHolder(holder, itemStatus.getGroupItemIndex());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bindGroupListener(holder,itemStatus,dt);
                }
            });

        } else if (itemStatus.getViewType() == ItemStatus.VIEW_TYPE_SUBITEM) {
            int groupItemIndex = itemStatus.getGroupItemIndex();
            onSubItemBindViewHolder(holder, itemStatus.getGroupItemIndex(), itemStatus
                    .getSubItemIndex(),groupItemStatus.get(groupItemIndex));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onSubItemClick((SubItemViewHolder)holder, itemStatus.getGroupItemIndex(), itemStatus.getSubItemIndex());

                }
            });
            int parentPosition = position - itemStatus.getSubItemIndex() - 1;
            Log.v("test","position="+position+"SubItemIndex="+itemStatus.getSubItemIndex()+"parentPosition="+parentPosition);
            final ItemStatus parentStatus= getItemStatusByPosition(parentPosition);//对应的一级菜单

            ((SubItemViewHolder) holder).tvMoreLoad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bindLoadMoreListener(holder,parentStatus,dt,parentPosition);
                }
            });

        }
    }

    private void bindLoadMoreListener(RecyclerView.ViewHolder holder2, ItemStatus itemStatus, DataTree dt,int parentPosition) {
        int groupItemIndex = itemStatus.getGroupItemIndex();
        //未展开
        if (!groupItemStatus.get(groupItemIndex)) {
            onGroupItemClick(false, groupItemIndex);
            groupItemStatus.set(groupItemIndex, true);
//                        notifyItemRangeInserted(holder.getAdapterPosition() + 1, dt.getSubItems().size());
            if (dt.getSubItems().size() > 0) {
                notifyItemRangeInserted(parentPosition + 1, dt.getSubItems().size() - 1);
                notifyDataSetChanged();
            } else {
//                      无二级条目不变化
            }
        } else {

            onGroupItemClick(true, groupItemIndex);
            groupItemStatus.set(groupItemIndex, false);
            if (dt.getSubItems().size() > 0) {
                notifyItemRangeRemoved(parentPosition + 1, dt.getSubItems().size() - 1);
                notifyDataSetChanged();
            } else {
//                      无二级条目不变化
            }
        }
    }

    private void bindGroupListener(RecyclerView.ViewHolder holder, ItemStatus itemStatus, DataTree dt) {
        int groupItemIndex = itemStatus.getGroupItemIndex();
        //未展开
        if (!groupItemStatus.get(groupItemIndex)) {
            onGroupItemClick(false, (GroupItemViewHolder) holder, groupItemIndex);
            groupItemStatus.set(groupItemIndex, true);
//                        notifyItemRangeInserted(holder.getAdapterPosition() + 1, dt.getSubItems().size());
            if (dt.getSubItems().size() > 0) {
                notifyItemRangeInserted(holder.getAdapterPosition() + 1, dt.getSubItems().size() - 1);
                notifyDataSetChanged();
            } else {
//                      无二级条目不变化
            }
        } else {

            onGroupItemClick(true, (GroupItemViewHolder) holder, groupItemIndex);
            groupItemStatus.set(groupItemIndex, false);
            if (dt.getSubItems().size() > 0) {
                notifyItemRangeRemoved(holder.getAdapterPosition() + 1, dt.getSubItems().size() - 1);
                notifyDataSetChanged();
            } else {
//                      无二级条目不变化
            }
        }
    }

    @Override
    public int getItemCount() {
        int itemCount = 0;
        if (groupItemStatus.size() == 0) {
            return 0;
        }
        for (int i = 0; i < dataTrees.size(); i++) {
            if (groupItemStatus.get(i)) {
                //一级加上二级条目
                itemCount += (dataTrees.get(i).getSubItems().size() + 1);
            } else {
//                itemCount++;
                //有二级条目未展开状态下默认显示第一个
                if (dataTrees.get(i).getSubItems().size() > 0) {
                    itemCount += 2;
                } else {
                    itemCount++;
                }
            }
        }
        return itemCount;
    }

    @Override
    protected SecondaryListAdapter.ItemStatus getItemStatusByPosition(int position) {
        ItemStatus itemStatus = new ItemStatus();

        int count = 0;
        int i = 0;

        for (i = 0; i < groupItemStatus.size(); i++) {

            if (count == position) {

                itemStatus.setViewType(ItemStatus.VIEW_TYPE_GROUPITEM);
                itemStatus.setGroupItemIndex(i);
                break;
//          pos大于计数时，item为groupItem(i - 1)中的某个subItem
            } else if (count > position) {

                itemStatus.setViewType(ItemStatus.VIEW_TYPE_SUBITEM);
                itemStatus.setGroupItemIndex(i - 1);
                if(groupItemStatus.get(i -1)){
                    itemStatus.setSubItemIndex(position - (count - dataTrees.get(i - 1).getSubItems().size()));
                } else {
                    //未展开永远显示第一个
                    itemStatus.setSubItemIndex(0);
                }
                break;

            }

            count++;
//          当轮询到的groupItem的状态为“开”的话，count需要加上该groupItem下面的子项目数目
            if (groupItemStatus.get(i)) {
                count += dataTrees.get(i).getSubItems().size();
            } else {
                //展开一个子条目
                if(dataTrees.get(i).getSubItems().size() > 0){
                    count++;
                }
            }


        }
//      简单地处理当轮询到最后一项groupItem的时候
        if (i >= groupItemStatus.size()) {
            itemStatus.setGroupItemIndex(i - 1);
            itemStatus.setViewType(ItemStatus.VIEW_TYPE_SUBITEM);
            if(groupItemStatus.get(i -1)){
                itemStatus.setSubItemIndex(position - (count - dataTrees.get(i - 1).getSubItems().size()));
            } else {
                //未展开永远显示第一个
                itemStatus.setSubItemIndex(0);
            }
        }

        return itemStatus;
    }

    @Override
    public RecyclerView.ViewHolder groupItemViewHolder(ViewGroup parent) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_item, parent, false);

        return new GroupItemViewHolder(v);
    }

    @Override
    public RecyclerView.ViewHolder subItemViewHolder(ViewGroup parent) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_item, parent, false);

        return new SubItemViewHolder(v);
    }

    @Override
    public void onGroupItemBindViewHolder(RecyclerView.ViewHolder holder, int groupItemIndex) {
        ((GroupItemViewHolder) holder).tvGroup.setText(dts.get(groupItemIndex).getGroupItem());
    }

        @Override
    public void onSubItemBindViewHolder(RecyclerView.ViewHolder holder, int groupItemIndex, int subItemIndex) {
        ((SubItemViewHolder) holder).tvSub.setText(dts.get(groupItemIndex).getSubItems().get(subItemIndex));
    }

    public void onSubItemBindViewHolder(RecyclerView.ViewHolder holder, int groupItemIndex, int subItemIndex, boolean isOpen) {
        ((SubItemViewHolder) holder).tvSub.setText(dts.get(groupItemIndex).getSubItems().get(subItemIndex));
        int size = dts.get(groupItemIndex).getSubItems().size();
        if ((0 == subItemIndex) && (size > 1) && !isOpen) {
            ((SubItemViewHolder) holder).tvMoreLoad.setVisibility(View.VISIBLE);
        } else {
            ((SubItemViewHolder) holder).tvMoreLoad.setVisibility(View.GONE);
        }
    }

    @Override
    public void onGroupItemClick(Boolean isExpand, GroupItemViewHolder holder, int groupItemIndex) {

        Toast.makeText(context, "group item " + String.valueOf(groupItemIndex) + " is expand " +
                String.valueOf(isExpand), Toast.LENGTH_SHORT).show();

    }

    public void onGroupItemClick(Boolean isExpand, int groupItemIndex) {

        Toast.makeText(context, "group item " + String.valueOf(groupItemIndex) + " is expand " +
                String.valueOf(isExpand), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSubItemClick(SubItemViewHolder holder, int groupItemIndex, int subItemIndex) {

        Toast.makeText(context, "sub item " + String.valueOf(subItemIndex) + " in group item " +
                String.valueOf(groupItemIndex), Toast.LENGTH_SHORT).show();

    }

    public static class GroupItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvGroup;

        public GroupItemViewHolder(View itemView) {
            super(itemView);

           tvGroup = (TextView) itemView.findViewById(R.id.tv);

        }
    }

    public static class SubItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvSub;
        TextView tvMoreLoad;

        public SubItemViewHolder(View itemView) {
            super(itemView);

            tvSub = (TextView) itemView.findViewById(R.id.tv);
            tvMoreLoad = itemView.findViewById(R.id.load_more);
        }
    }


}

