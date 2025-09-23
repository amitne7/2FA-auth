package auth.android.app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import auth.android.app.R;
import auth.android.app.responsemodel.account.AccountData;
import auth.android.app.utils.Constants;
import auth.android.app.utils.Utils;

public class AccountListAdapter extends BaseAdapter {
    private Context context;
    private List<AccountData> accountDataList;

    public AccountListAdapter(Context context, List<AccountData> accountDataList) {
        this.context = context;
        this.accountDataList = accountDataList;
    }

    @Override
    public int getCount() {
        return accountDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return accountDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        AccountViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_account_list, viewGroup, false);
            viewHolder = new AccountViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AccountViewHolder) convertView.getTag();
        }
        viewHolder.tvInitials.setText(Utils.acronym(accountDataList.get(i).getName()));
        viewHolder.tvName.setText(accountDataList.get(i).getName());
        viewHolder.tvEmail.setText(accountDataList.get(i).getEmail());
        return convertView;
    }

    public class AccountViewHolder {
        TextView tvInitials;
        TextView tvName;
        TextView tvEmail;

        public AccountViewHolder(View view) {
            tvInitials = view.findViewById(R.id.tv_initials);
            tvName = view.findViewById(R.id.tv_name);
            tvEmail = view.findViewById(R.id.tv_email);
            tvInitials.setTypeface(Utils.getFont(context, Constants.BOLD));
            tvName.setTypeface(Utils.getFont(context, Constants.BOLD));
            tvEmail.setTypeface(Utils.getFont(context, Constants.REGULAR));
        }
    }
}
