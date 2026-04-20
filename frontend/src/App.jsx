import FoodItemManager from './components/FoodItemManager'
import { Navigate, Route, Routes } from 'react-router-dom'
import './App.css'

function App() {
  return (
    <div className="app-shell">
      <Routes>
        <Route path="/add-fooditem" element={<FoodItemManager view="add" />} />
        <Route path="/get-fooditems" element={<FoodItemManager view="list" />} />
        <Route path="*" element={<Navigate to="/add-fooditem" replace />} />
      </Routes>
    </div>
  )
}

export default App
