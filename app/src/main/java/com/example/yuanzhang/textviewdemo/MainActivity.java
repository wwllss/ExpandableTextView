package com.example.yuanzhang.textviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.library.expandabletv.ExpandableTextView;


public class MainActivity extends Activity {

    ExpandableTextView tv;

    String s = "起来饥寒交迫的奴隶\n" +
            "起来全世界受苦的人\n" +
            "满腔的热血已经沸腾要为真理而斗争\n" +
            "旧世界打个落花流水奴隶们起来起来\n" +
            "不要说我们一无所有我们要做天下的主人\n" +
            "\n" +
            "这是最后的斗争团结起来到明天\n" +
            "英特纳雄耐尔就一定要实现\n" +
            "这是最后的斗争团结起来到明天\n" +
            "英特纳雄耐尔就一定要实现\n" +
            "\n" +
            "从来就没有什麽救世主也不靠神仙皇帝\n" +
            "要创造人类的幸福全靠我们自己\n" +
            "我们要夺回劳动果实让思想冲破牢笼\n" +
            "快把那炉火烧得通红趁热打铁才能成功\n" +
            "\n" +
            "这是最后的斗争团结起来到明天\n" +
            "英特纳雄耐尔就一定要实现\n" +
            "这是最后的斗争团结起来到明天\n" +
            "英特纳雄耐尔就一定要实现\n" +
            "\n" +
            "最可恨那些毒蛇猛兽吃尽了我们的血肉\n" +
            "一旦把他们消灭乾净鲜红的太阳照遍全球\n" +
            "\n" +
            "这是最后的斗争团结起来到明天\n" +
            "英特纳雄耐尔就一定要实现\n" +
            "这是最后的斗争团结起来到明天\n" +
            "英特纳雄耐尔就一定要实现\n" +
            "英特纳雄耐尔就一定要实现";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (ExpandableTextView) findViewById(R.id.tv);
    }
    public void method(View view) {
        tv.setContentText(s);
    }
}
