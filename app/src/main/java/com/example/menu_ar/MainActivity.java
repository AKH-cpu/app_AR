package com.example.menu_ar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArFragment arFragment;

    private ModelRenderable bearRenderable, catRenderable, cowRenderable, dogRenderable,
                            elephantRenderable, ferretRenderable,hippoptamusRenderable,
                            horseRenderable, koala_bearRenderable, lionRenderable, reindeerRenderable,
                             wolverineRenderable  ;

    ImageView bear,cat, cow, dog,elephant, ferret,hippoptamus, horse, koala_bear, lion, reindeer,
            wolverine;

    View arrayView[];
    ViewRenderable name_animal;

    int selected = 1; // Default bear



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        // View
        bear = (ImageView)findViewById(R.id.bear);
        cat = (ImageView)findViewById(R.id.cat);
        cow = (ImageView)findViewById(R.id.cow);
        dog = (ImageView)findViewById(R.id.dog);
        elephant = (ImageView)findViewById(R.id.elephant);
        ferret = (ImageView)findViewById(R.id.ferret);
        hippoptamus = (ImageView)findViewById(R.id.hippopotamus);
        horse = (ImageView)findViewById(R.id.horse);
        koala_bear = (ImageView)findViewById(R.id.koala_bear);
        lion = (ImageView)findViewById(R.id.lion);
        reindeer = (ImageView)findViewById(R.id.reindeer);
        wolverine = (ImageView)findViewById(R.id.wolverine);

        setArrayView();
        setClickListener();
        setupModel();

        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                // When the user tapes on plan , we will add the model
                    Anchor anchor= hitResult.createAnchor();
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel(anchorNode, selected);

            }
        });

    }


    private void setupModel() {
        ModelRenderable.builder()
                .setSource(this, R.raw.bear)
                .build().thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(throwable ->{
                    Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                     return null;
                }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.cat)
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(throwable ->{
                            Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.cow)
                .build().thenAccept(renderable -> cowRenderable = renderable)
                .exceptionally(throwable ->{
                            Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.dog)
                .build().thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(throwable ->{
                            Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.elephant)
                .build().thenAccept(renderable -> elephantRenderable = renderable)
                .exceptionally(throwable ->{
                            Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.ferret)
                .build().thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(throwable ->{
                            Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.hippopotamus)
                .build().thenAccept(renderable -> hippoptamusRenderable = renderable)
                .exceptionally(throwable ->{
                            Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.horse)
                .build().thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(throwable ->{
                            Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.koala_bear)
                .build().thenAccept(renderable -> koala_bearRenderable = renderable)
                .exceptionally(throwable ->{
                            Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.lion)
                .build().thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(throwable ->{
                            Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.reindeer)
                .build().thenAccept(renderable -> reindeerRenderable = renderable)
                .exceptionally(throwable ->{
                            Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.wolverine)
                .build().thenAccept(renderable -> wolverineRenderable = renderable)
                .exceptionally(throwable ->{
                            Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if(selected == 1){
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();
        } else if(selected == 2){
            TransformableNode cat = new TransformableNode(arFragment.getTransformationSystem());
            cat.setParent(anchorNode);
            cat.setRenderable(catRenderable);
            cat.select();

        }else if(selected == 3){
            TransformableNode dog = new TransformableNode(arFragment.getTransformationSystem());
            dog.setParent(anchorNode);
            dog.setRenderable(dogRenderable);
            dog.select();

        }else if(selected == 4){
            TransformableNode cow = new TransformableNode(arFragment.getTransformationSystem());
            cow.setParent(anchorNode);
            cow.setRenderable(cowRenderable);
            cow.select();

        }else if(selected == 5){
            TransformableNode elephant = new TransformableNode(arFragment.getTransformationSystem());
            elephant.setParent(anchorNode);
            elephant.setRenderable(elephantRenderable);
            elephant.select();

        }else if(selected == 6){
            TransformableNode ferret = new TransformableNode(arFragment.getTransformationSystem());
            ferret.setParent(anchorNode);
            ferret.setRenderable(ferretRenderable);
            ferret.select();

        }else if(selected == 7){
            TransformableNode hippoptamus = new TransformableNode(arFragment.getTransformationSystem());
            hippoptamus.setParent(anchorNode);
            hippoptamus.setRenderable(hippoptamusRenderable);
            hippoptamus.select();

        }else if(selected == 8){
            TransformableNode horse = new TransformableNode(arFragment.getTransformationSystem());
            horse.setParent(anchorNode);
            horse.setRenderable(horseRenderable);
            horse.select();

        }else if(selected == 9){
            TransformableNode koala_bear = new TransformableNode(arFragment.getTransformationSystem());
            koala_bear.setParent(anchorNode);
            koala_bear.setRenderable(koala_bearRenderable);
            koala_bear.select();

        }else if(selected == 10){
            TransformableNode lion = new TransformableNode(arFragment.getTransformationSystem());
            lion.setParent(anchorNode);
            lion.setRenderable(lionRenderable);
            lion.select();

        }else if(selected == 11){
            TransformableNode reindeer = new TransformableNode(arFragment.getTransformationSystem());
            reindeer.setParent(anchorNode);
            reindeer.setRenderable(reindeerRenderable);
            reindeer.select();

        }else if(selected == 12){
            TransformableNode wolverine = new TransformableNode(arFragment.getTransformationSystem());
            wolverine.setParent(anchorNode);
            wolverine.setRenderable(wolverineRenderable);
            wolverine.select();

        }
    }

    private void setClickListener() {
        for(int i =0; i<=arrayView.length; i++){
            arrayView[i].setOnClickListener(this);
        }
    }

    private void setArrayView() {
        arrayView = new View[]{
                bear,cat, cow, dog,elephant, ferret,hippoptamus, horse, koala_bear, lion, reindeer,
                wolverine
        };
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bear) {selected = 1; setBackground(v.getId());}
        else if(v.getId() == R.id.cat) {selected = 2; setBackground(v.getId());}
        else if(v.getId() == R.id.dog) {selected = 3; setBackground(v.getId());}
        else if(v.getId() == R.id.cow) {selected = 4; setBackground(v.getId());}
        else if(v.getId() == R.id.elephant) {selected = 5; setBackground(v.getId());}
        else if(v.getId() == R.id.ferret) {selected = 6; setBackground(v.getId());}
        else if(v.getId() == R.id.hippopotamus) {selected = 7; setBackground(v.getId());}
        else if(v.getId() == R.id.horse) {selected = 8; setBackground(v.getId());}
        else if(v.getId() == R.id.koala_bear) {selected = 9; setBackground(v.getId());}
        else if(v.getId() == R.id.lion) {selected = 10; setBackground(v.getId());}
        else if(v.getId() == R.id.reindeer) {selected = 11; setBackground(v.getId());}
        else if(v.getId() == R.id.wolverine) {selected = 12; setBackground(v.getId());}

    }

    private void setBackground(int id) {
        for(int i =0; i<=arrayView.length; i++){
            if (arrayView[i].getId() == id) arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            else arrayView[i].setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
