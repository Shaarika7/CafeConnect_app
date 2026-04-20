# CafeConnect Frontend

A React + Vite frontend application for managing food items via the Spring Boot backend controller.

## Prerequisites

- Node.js (v16+)
- npm or npm.cmd (Windows)

## Installation

Install project dependencies:

```bash
npm.cmd install
```

## Running the Application

### Development Mode (with HMR)

Start the development server:

```bash
npm start
```

Or use the dev alias:

```bash
npm run dev
```

The app will be available at **http://127.0.0.1:5173/**

### Production Build

Build the application for production:

```bash
npm run build
```

Preview the production build:

```bash
npm run preview
```

## Features

- **Add Food Item**: Submit food item details (name, category, price, availability) to the backend via POST `/food/save`
- **Get Food Items**: Display all food items from the backend via GET `/food/list` in a formatted table
- **Two-Page Navigation**: Separate pages for add and list operations using React Router

## Configuration

### Backend URL

By default, the frontend targets **http://localhost:8090** for backend API calls.

To use a different backend URL, set the `VITE_API_BASE_URL` environment variable:

```bash
set VITE_API_BASE_URL=http://your-backend-url:port
npm start
```

## Project Structure

```
src/
├── App.jsx                    # Main app component with routes
├── main.jsx                   # Entry point with React Router setup
├── components/
│   ├── FoodItemManager.jsx   # Form and list UI component
│   └── FoodItemManager.css   # Styling for food item pages
└── index.css                 # Global styles
```

## API Integration

The frontend consumes these Spring Backend endpoints:

- **POST /food/save** - Add a new food item
- **GET /food/list** - Retrieve all food items

Form submission sends `application/x-www-form-urlencoded` data for `@ModelAttribute` binding.

## Available Scripts

- `npm start` - Start development server
- `npm run dev` - Alias for dev server
- `npm run build` - Build for production
- `npm run lint` - Run ESLint
- `npm run preview` - Preview production build
