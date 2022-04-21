
package com.mygdx.game.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.Entitys.Event;
import com.mygdx.game.Entitys.Storm;

import java.util.ArrayList;

import static com.mygdx.utils.Constants.TILE_SIZE;


/**
 * Responsible for creating all weather based entities
 */
public final class EventManager {

    // Declare variables
    private static boolean initialized = false;
    private static boolean isRunning = false;
    private static JsonValue settings;

    private static int maxEventCount;
    private static ArrayList<Event> events;

    private static Vector2[] zones;
    private static ArrayList<Integer> availableZones;

    private static float spawnChance;
    private static float spawnTimerMax;
    private static float spawnTimer;


    public static void Initialize() {
        // Initialize variables
        initialized = true;
        isRunning = false;
        settings = GameManager.getSettings().get("events");

        maxEventCount = settings.getInt("maxConcurrent");
        events = new ArrayList<>();

        int positionCount = settings.get("zones").asFloatArray().length / 2;
        zones = new Vector2[positionCount];
        availableZones = new ArrayList<>();
        float[] rawPositions = settings.get("zones").asFloatArray();
        for (int i = 0; i < positionCount; i++) {
            zones[i] = new Vector2(
                rawPositions[i * 2] * TILE_SIZE,
                rawPositions[i * 2 + 1] * TILE_SIZE);
            availableZones.add(i);
        }

        spawnChance = settings.getFloat("spawnChance");
        spawnTimerMax = settings.getFloat("spawnTimerMax");
        spawnTimer = 0.0f;
    }


    public static void reset() {
        if (initialized) {
            // Reset all variables
            initialized = false;
            isRunning = false;
            maxEventCount = -1;
            events = null;
            zones = null;
            availableZones = null;
            spawnTimer = 0;
        }
    }


    private static void tryInit() {
        if (!initialized) {
            Initialize();
        }
    }


    public static void SpawnEvents() {
        tryInit();

        // Update variables
        isRunning = true;

        availableZones.clear();
        for (int i = 0; i < zones.length; i++) availableZones.add(i);
        int count = Math.min(maxEventCount, zones.length);
        events = new ArrayList<>();
    }


    private static float getRandomDuration() {
        // Return random duration for event
        float min = settings.getFloat("durationMin");
        float max = settings.getFloat("durationMin");
        return (float)(Math.random() * (max - min) + min);
    }


    public static void update() {
        // Remove dead event
        for (int i = 0; i < events.size(); i++) {
            if (!events.get(i).isAlive()) {
                availableZones.add(events.get(i).getZone());
                events.get(i).remove();
                events.remove(i);
                i--;
            }
        }

        // Add new event on timer
        if (availableZones.size() > 0 && events.size() < maxEventCount) {
            spawnTimer = Math.max(0, spawnTimer - Gdx.graphics.getDeltaTime());
            if (spawnTimer == 0) {
                if (Math.random() < spawnChance) {
                    int index = availableZones.remove((int) (Math.random() * availableZones.size()));
                    events.add(new Storm(zones[index].cpy(), getRandomDuration(), index));
                }
                spawnTimer = spawnTimerMax;
            }
        } else spawnTimer = spawnTimerMax;
    }


    public static JsonValue getSettings() { tryInit(); return settings; }
}