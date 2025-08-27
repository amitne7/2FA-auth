package auth.android.app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import auth.android.app.responsemodel.account.AccountData;
import auth.android.app.utils.Constants;
import auth.android.app.utils.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import event.msvc.android.R;

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
        @BindView(R.id.tv_initials)
        TextView tvInitials;

        @BindView(R.id.tv_name)
        TextView tvName;

        @BindView(R.id.tv_email)
        TextView tvEmail;

        public AccountViewHolder(View view) {
            ButterKnife.bind(this, view);
            tvInitials.setTypeface(Utils.getFont(context, Constants.BOLD));
            tvName.setTypeface(Utils.getFont(context, Constants.REGULAR));
            tvEmail.setTypeface(Utils.getFont(context, Constants.REGULAR));
        }
    }
}
